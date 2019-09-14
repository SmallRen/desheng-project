package com.desheng.service.impl;

import com.desheng.mapper.WzItfDetailedMapper;
import com.desheng.mapper.WzItfMapper;
import com.desheng.mapper.WzWorkLineMapper;
import com.desheng.pojo.*;
import com.desheng.service.wzgd.WzItfService;
import com.desheng.util.DateUtils;
import com.desheng.util.ResultMsg;
import com.desheng.vo.WzItfVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wzItfService")
public class WzItfServiceImpl implements WzItfService {
    @Autowired
    private WzItfMapper wzItfMapper;
    @Autowired
    private WzItfDetailedMapper wzItfDetailedMapper;
    @Autowired
    private WzWorkLineMapper wzWorkLineMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Object addNewWzItf(WzItf wzItf, String[] points, String[] turnover) {
        if ((points == null && points.length < 0) || (turnover == null && turnover.length < 0)) {
            return ResultMsg.failure("路线不能为空");
        }
        //1.先插入表头信息 成功后才执行 插入路线 和插入物资
        String gdh = DateUtils.getDocumentNumber();//生产工单号
        wzItf.setGdMark(gdh);
        //sql返回自增ID
        int b = wzItfMapper.insertSelective(wzItf);
        if (b <= 0) {
            return ResultMsg.failure("工单保存失败！请检查工单录入信息");
        }
        //插入物资
        String[] wzName = wzItf.getWzName(); //物资名称
        String[] wzNumber = wzItf.getWzNumber();//物资数量
        String[] wzSspce = wzItf.getWzSspce();//物资规格
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
            map.put("point" + (i + 1), points[i]);
            // workLine.setPoint1(points[i]);
            map.put("point" + (i + 1) + "Turnover", turnover[i]);
            // workLine.setPoint1Turnover(turnover[i]);
            //这里还要记录点与点之间的间隔时间 ，还要写逻辑处理
            //workLine.setPoint1Time();
        }
        int i1 = wzWorkLineMapper.insertSelectiveMap(map);
        if (i1 <= 0) {
            //当插入成功后还要插入一条数据 来继续  人工 录入点位
            map.clear();
            map.put("pointSlicer", 2);
            map.put("wzItfId", wzItf.getId());
            wzWorkLineMapper.insertSelectiveMap(map);
            return ResultMsg.failure("物资路线点位保存失败！请检查工单物资路线点位信息");
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
                str.append(wzWorkLine.getPoint1Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint1());
                break;
            }
            if (wzWorkLine.getPoint2() != null) {//第一个点到第二个点的 间隔时间
                str.append(wzWorkLine.getPoint1Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint1() + "→" +
                        wzWorkLine.getPoint2Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint2() + " " + wzWorkLine.getPoint1Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint3() != null) {
                str.append(wzWorkLine.getPoint2Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint2() + "→" +
                        wzWorkLine.getPoint3Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint3() + " " + wzWorkLine.getPoint2Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint4() != null) {
                str.append(wzWorkLine.getPoint3Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint3() + "→" +
                        wzWorkLine.getPoint4Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint4() + " " + wzWorkLine.getPoint3Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint5() != null) {
                str.append(wzWorkLine.getPoint4Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint4() + "→" +
                        wzWorkLine.getPoint5Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint5() + " " + wzWorkLine.getPoint4Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint6() != null) {
                str.append(wzWorkLine.getPoint5Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint5() + "→" +
                        wzWorkLine.getPoint6Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint6() + " " + wzWorkLine.getPoint5Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint7() != null) {
                str.append(wzWorkLine.getPoint6Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint6() + "→" +
                        wzWorkLine.getPoint7Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint7() + " " + wzWorkLine.getPoint6Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint8() != null) {
                str.append(wzWorkLine.getPoint7Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint7() + "→" +
                        wzWorkLine.getPoint8Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint8() + " " + wzWorkLine.getPoint7Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint9() != null) {
                str.append(wzWorkLine.getPoint8Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint8() + "→" +
                        wzWorkLine.getPoint9Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint9() + " " + wzWorkLine.getPoint8Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint10() != null) {
                str.append(wzWorkLine.getPoint9Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint9() + "→" +
                        wzWorkLine.getPoint10Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint10() + " " + wzWorkLine.getPoint9Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint11() != null) {
                str.append(wzWorkLine.getPoint10Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint10() + "→" +
                        wzWorkLine.getPoint11Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint11() + " " + wzWorkLine.getPoint10Time() + "分钟 ");
            } else {
                break;
            }
            if (wzWorkLine.getPoint12() != null) {
                str.append(wzWorkLine.getPoint11Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint11() + "→" +
                        wzWorkLine.getPoint12Turnover().toCharArray()[2] + ":" + wzWorkLine.getPoint12() + " " + wzWorkLine.getPoint11Time() + "分钟 ");
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
}
