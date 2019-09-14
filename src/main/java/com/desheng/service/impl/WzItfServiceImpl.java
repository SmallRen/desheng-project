package com.desheng.service.impl;

import com.desheng.mapper.NoticeMapper;
import com.desheng.mapper.WzItfDetailedMapper;
import com.desheng.mapper.WzItfMapper;
import com.desheng.mapper.WzWorkLineMapper;
import com.desheng.pojo.*;
import com.desheng.service.wzgd.WzItfService;
import com.desheng.util.DateUtils;
import com.desheng.util.ResultMsg;
import com.desheng.util.StringUtils;
import com.desheng.vo.WzItfVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wzItfService")
public class WzItfServiceImpl implements WzItfService {
    private static final Logger log = LoggerFactory.getLogger(WzItfServiceImpl.class);
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    private WzItfMapper wzItfMapper;
    @Autowired
    private WzItfDetailedMapper wzItfDetailedMapper;
    @Autowired
    private WzWorkLineMapper wzWorkLineMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Map<String, Object> addNewWzItf(WzItf wzItf) throws Exception {
        //1.先插入表头信息 成功后才执行 插入路线 和插入物资
        String gdh = DateUtils.getDocumentNumber();//生产工单号
        wzItf.setGdMark(gdh);
        try {
            //sql返回自增ID
            int b = wzItfMapper.insertSelective(wzItf);
            if (b <= 0) {
                return ResultMsg.failure("工单保存失败！请检查工单录入信息");
            }
            //插入物资
            String[] wzName = wzItf.getWzName(); //物资名称
            String[] wzNumber = wzItf.getWzNumber();//物资数量
            String[] wzSspce = wzItf.getWzSspce();//物资规格
            String[] points = wzItf.getPoint();//物资规格
            if (wzName != null && wzName.length > 0) {//当物资不为空的时候才记录物资信息
                for (int i = 0; i < wzName.length; i++) {
                    WzItfDetailed wzItfDetailed = new WzItfDetailed();
                    wzItfDetailed.setWzName(wzName[i]);
                    wzItfDetailed.setWzSspce(wzSspce[i]);
                    wzItfDetailed.setWzNumber(wzNumber[i]);
                    wzItfDetailed.setWzItfId(wzItf.getId());
                    int i1 = wzItfDetailedMapper.insertSelective(wzItfDetailed);
                    if (i1 <= 0) {
                        return ResultMsg.failure("物资信息保存失败！请检查工单物资信息");
                    }
                }
            }
            // 插入线路
            Map<String, Object> map = new HashMap<>();
            map.put("wzItfId", wzItf.getId());
            map.put("pointNumber", points.length);
            map.put("pointSlicer", 1);// 系统路线
            for (int i = 0; i < points.length; i++) {
                map.put("point" + (i + 1), points[i].split("→")[0]);
                // workLine.setPoint1(points[i]);
                map.put("point" + (i + 1) + "Turnover", points[i].split("→")[1]);
                // workLine.setPoint1Turnover(turnover[i]);
                //这里还要记录点与点之间的间隔时间 ，还要写逻辑处理
                //workLine.setPoint1Time();
            }
            int i1 = wzWorkLineMapper.insertSelectiveMap(map);
            if (i1 > 0) {
                //当插入成功后还要插入一条数据 来继续  人工 录入点位
                map.clear();
                map.put("pointSlicer", 2);
                map.put("wzItfId", wzItf.getId());
                // map.put("pointNumber", points.length);
                int i = wzWorkLineMapper.insertSelectiveMap(map);
                if (i < 0) {
                    return ResultMsg.failure("物资路线点位保存失败！请检查工单物资路线点位信息");
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return ResultMsg.success("工单保存成功");
    }

    @Override
    public List<WzItfVo> queryWzItfAll() {
        //查询物资 //到时候根据角色来查询物资信息
        List<WzItfVo> wzItfs = wzItfMapper.selectByExampleVo(null);
        if (wzItfs != null && wzItfs.size() > 0) {
            WzItfDetailedExample wzItfDetailedExample = new WzItfDetailedExample();
            WzWorkLineExample wzWorkLineExample = new WzWorkLineExample();
            for (WzItfVo wzItfVo : wzItfs) {
                //根据物资主键查询对应的物资清单
                wzItfDetailedExample.clear();
                wzItfDetailedExample.createCriteria().andWzItfIdEqualTo(wzItfVo.getId());
                List<WzItfDetailed> wzItfDetaileds = wzItfDetailedMapper.selectByExample(wzItfDetailedExample);
                StringBuilder str = new StringBuilder();
                for (WzItfDetailed wzItfDetailed : wzItfDetaileds) {
                    //拼 成 物资x数量
                    str.append(wzItfDetailed.getWzName() + "x" + wzItfDetailed.getWzNumber() + " ");
                }
                //set物资
                wzItfVo.setWzItfDetailed(str.toString());
                //1是系统路线 2实际路线
                wzWorkLineExample.clear();
                wzWorkLineExample.createCriteria().andWzItfIdEqualTo(wzItfVo.getId()).andPointSlicerEqualTo(1);
                List<WzWorkLine> wzWorkLines = wzWorkLineMapper.selectByExample(wzWorkLineExample);
                //拼接路线
                String jointLine = jointLine(wzWorkLines);
                //set系统路线
                wzItfVo.setWzWorkLine(jointLine);
            }
        }
        return wzItfs;
    }

    /**
     * 拼接路线
     *
     * @param wzWorkLines 路线集合
     */
    private String jointLine(List<WzWorkLine> wzWorkLines) {
        //拼成如格式 ： 出 A → 进B  10分钟
        StringBuilder str = new StringBuilder();
        for (WzWorkLine wzWorkLine : wzWorkLines) {
            //如果只有一个点 直接结束循环
            if (wzWorkLine.getPoint1() != null && wzWorkLine.getPoint2() == null) {
                str.append(wzWorkLine.getPoint1Turnover() + ":" + wzWorkLine.getPoint1());
                break;
            }
            if (wzWorkLine.getPoint2() != null) {//第一个点到第二个点的 间隔时间
                str.append(wzWorkLine.getPoint1Turnover() + ":" + wzWorkLine.getPoint1() + "→" +
                        wzWorkLine.getPoint2Turnover() + ":" + wzWorkLine.getPoint2() + " " + wzWorkLine.getPoint1Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint3() != null) {
                str.append(wzWorkLine.getPoint2Turnover() + ":" + wzWorkLine.getPoint2() + "→" +
                        wzWorkLine.getPoint3Turnover() + ":" + wzWorkLine.getPoint3() + " " + wzWorkLine.getPoint2Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint4() != null) {
                str.append(wzWorkLine.getPoint3Turnover() + ":" + wzWorkLine.getPoint3() + "→" +
                        wzWorkLine.getPoint4Turnover() + ":" + wzWorkLine.getPoint4() + " " + wzWorkLine.getPoint3Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint5() != null) {
                str.append(wzWorkLine.getPoint4Turnover() + ":" + wzWorkLine.getPoint4() + "→" +
                        wzWorkLine.getPoint5Turnover() + ":" + wzWorkLine.getPoint5() + " " + wzWorkLine.getPoint4Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint6() != null) {
                str.append(wzWorkLine.getPoint5Turnover() + ":" + wzWorkLine.getPoint5() + "→" +
                        wzWorkLine.getPoint6Turnover() + ":" + wzWorkLine.getPoint6() + " " + wzWorkLine.getPoint5Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint7() != null) {
                str.append(wzWorkLine.getPoint6Turnover() + ":" + wzWorkLine.getPoint6() + "→" +
                        wzWorkLine.getPoint7Turnover() + ":" + wzWorkLine.getPoint7() + " " + wzWorkLine.getPoint6Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint8() != null) {
                str.append(wzWorkLine.getPoint7Turnover() + ":" + wzWorkLine.getPoint7() + "→" +
                        wzWorkLine.getPoint8Turnover() + ":" + wzWorkLine.getPoint8() + " " + wzWorkLine.getPoint7Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint9() != null) {
                str.append(wzWorkLine.getPoint8Turnover() + ":" + wzWorkLine.getPoint8() + "→" +
                        wzWorkLine.getPoint9Turnover() + ":" + wzWorkLine.getPoint9() + " " + wzWorkLine.getPoint8Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint10() != null) {
                str.append(wzWorkLine.getPoint9Turnover() + ":" + wzWorkLine.getPoint9() + "→" +
                        wzWorkLine.getPoint10Turnover() + ":" + wzWorkLine.getPoint10() + " " + wzWorkLine.getPoint9Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint11() != null) {
                str.append(wzWorkLine.getPoint10Turnover() + ":" + wzWorkLine.getPoint10() + "→" +
                        wzWorkLine.getPoint11Turnover() + ":" + wzWorkLine.getPoint11() + " " + wzWorkLine.getPoint10Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint12() != null) {
                str.append(wzWorkLine.getPoint11Turnover() + ":" + wzWorkLine.getPoint11() + "→" +
                        wzWorkLine.getPoint12Turnover() + ":" + wzWorkLine.getPoint12() + " " + wzWorkLine.getPoint11Time() + "分钟 ");
            } else {
                break;
            }
        }
        return str.toString();

    }

    @Override
    public List<WzItfDetailed> queryWzItDetailedById(Integer id) {
        WzItfDetailedExample wzItfDetailedExample = new WzItfDetailedExample();
        //根据物资主键查询对应的物资清单
        wzItfDetailedExample.createCriteria().andWzItfIdEqualTo(id);
        List<WzItfDetailed> wzItfDetaileds = wzItfDetailedMapper.selectByExample(wzItfDetailedExample);
        return wzItfDetaileds;
    }

    @Override
    public List<WzWorkLine> queryWzWorkLineById(Integer id) {
        WzWorkLineExample wzWorkLineExample = new WzWorkLineExample();
        wzWorkLineExample.createCriteria().andWzItfIdEqualTo(id);
        List<WzWorkLine> wzWorkLines = wzWorkLineMapper.selectByExample(wzWorkLineExample);
        return wzWorkLines;
    }

    @Override
    public WzItfVo queryWzItfById(Integer id) {
        WzItfVo wzItfVo = wzItfMapper.selectByPrimaryKeyVo(id);
        if (wzItfVo != null) {
            WzItfDetailedExample wzItfDetailedExample = new WzItfDetailedExample();
            WzWorkLineExample wzWorkLineExample = new WzWorkLineExample();
            //根据物资主键查询对应的物资清单
            wzItfDetailedExample.createCriteria().andWzItfIdEqualTo(wzItfVo.getId());
            List<WzItfDetailed> wzItfDetaileds = wzItfDetailedMapper.selectByExample(wzItfDetailedExample);
            StringBuilder str = new StringBuilder();
            for (WzItfDetailed wzItfDetailed : wzItfDetaileds) {
                str.append(wzItfDetailed.getWzName() + "x" + wzItfDetailed.getWzNumber() + " ");
            }
            //set物资
            wzItfVo.setWzItfDetailed(str.toString());
            //1是系统路线 2实际路线
            wzWorkLineExample.createCriteria().andWzItfIdEqualTo(wzItfVo.getId()).andPointSlicerEqualTo(1);
            List<WzWorkLine> wzWorkLines = wzWorkLineMapper.selectByExample(wzWorkLineExample);
            //拼接路线
            String jointLine = jointLine(wzWorkLines);
            //set系统路线
            wzItfVo.setWzWorkLine(jointLine);
            return wzItfVo;
        }
        return null;
    }

    /**
     * 根据工单ID 复制此工单
     *
     * @param id  工单ID
     * @param num 复制数量
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int copyWzItfGd(Integer id, Integer num) throws Exception {
        for (int j = 0; j < num; j++) {
            try {
                //1查询工单信息
                WzItf wzItf = wzItfMapper.selectByPrimaryKey(id);
                String gdh = DateUtils.getDocumentNumber();//生产工单号
                wzItf.setGdMark(gdh);
                wzItf.setId(null);//把ID设为null 不能插入ID 因为是主键
                int i = wzItfMapper.insertSelective(wzItf); //返回自增ID
                //插入新工单成功 就插入路线和物资
                if (i > 0) {
                    //2.根据工单ID 查询物资 和线路
                    WzItfDetailedExample wzItfDetailedExample = new WzItfDetailedExample();
                    //根据物资主键查询对应的物资清单
                    wzItfDetailedExample.createCriteria().andWzItfIdEqualTo(id);
                    List<WzItfDetailed> wzItfDetaileds = wzItfDetailedMapper.selectByExample(wzItfDetailedExample);
                    for (WzItfDetailed wzItfDetailed : wzItfDetaileds) {
                        wzItfDetailed.setWzItfId(wzItf.getId());//取出自增ID
                        wzItfDetailed.setId(null);
                        wzItfDetailedMapper.insertSelective(wzItfDetailed);
                    }

                    //查询系统的路线只查询系统路线
                    WzWorkLineExample wzWorkLineExample = new WzWorkLineExample();
                    //1是系统路线 2实际路线
                    wzWorkLineExample.createCriteria().andWzItfIdEqualTo(id).andPointSlicerEqualTo(1);
                    List<WzWorkLine> wzWorkLines = wzWorkLineMapper.selectByExample(wzWorkLineExample);
                    for (WzWorkLine wzWorkLine : wzWorkLines) {
                        wzWorkLine.setWzItfId(wzItf.getId());//取出自增ID
                        wzWorkLine.setId(null);
                        int i1 = wzWorkLineMapper.insertSelective(wzWorkLine);//插入系统路线
                        if (i1 > 0) {
                            WzWorkLine wzWorkLine1 = new WzWorkLine();//插入人工路线
                            wzWorkLine1.setWzItfId(wzItf.getId());//取出自增ID
                            wzWorkLine1.setPointSlicer(2);//人工标识
                            wzWorkLineMapper.insertSelective(wzWorkLine1);//插入系统路线
                        }
                    }
                }

            } catch (Exception e) {
                throw e;
            }
        }
        return 1;
    }

    @Override
    public void executeTimeOut() {
        List<Map<String, Object>> mapList = wzItfMapper.selectByTimeOut();
        // 系统线路
        Map<String, Object> systemMap = mapList.get(0);
        // 人工线路
        Map<String, Object> artificialMap = mapList.get(1);
        // 获取系统工单人工线路当前需要扫描的点位数
        Integer artificialPointNum = (Integer) artificialMap.get("point_number");
        if (artificialPointNum != 1) {
            int id = Integer.valueOf(systemMap.get("wz_itf_id").toString());
            // 获取上一个点时间/点位
            String preStr = (String) artificialMap.get("point" + (artificialPointNum - 1) + "_time");
            String point = (String) artificialMap.get("point" + (artificialPointNum - 1));
            String sysPoint = (String) systemMap.get("point" + artificialPointNum);
            // 判断上一个点扫描时间不能为空
            if (StringUtils.isNotBlank(preStr)) {
                SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date preDate = null;
                try {
                    preDate = spf.parse(preStr);
                    int min = Integer.valueOf(systemMap.get("point" + artificialPointNum + "_time").toString()) * 60;
                    Date nowDate = new Date();
                    // 点位间隔时间
                    int s = (int) ((nowDate.getTime() - preDate.getTime()) / 1000);
                    // 比较
                    if (s > min) {
                        // 发送通知
                        int count = noticeMapper.checkSendNotice(id, "point" + artificialPointNum);
                        if (count == 0) {
                            Notice notice = new Notice();
                            notice.setWzItfId(id);
                            notice.setPoint("point" + artificialPointNum);
                            notice.setPushTime(new Date());
                            notice.setContent("您的点位在" + point + "到" + "系统预设点" + sysPoint + "超时。" + "超时时间：" + (s - min) + "秒");
                            noticeMapper.insertSelective(notice);
                        }
                    }
                } catch (ParseException e) {
                    log.error("获取工单{}点位扫描时间格式不正确", artificialMap.get("wz_itf_id"));
                    e.printStackTrace();
                }

            }


        }

    }
}
