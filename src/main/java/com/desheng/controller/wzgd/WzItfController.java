package com.desheng.controller.wzgd;

import com.desheng.pojo.WzItf;
import com.desheng.pojo.WzItfDetailed;
import com.desheng.pojo.WzWorkLine;
import com.desheng.service.wzgd.WzItfService;
import com.desheng.service.wzgd.WzProductService;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;
import com.desheng.vo.WzItfVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class WzItfController {
    private static Logger log = LoggerFactory.getLogger(WzItfController.class);

    @Autowired
    private WzItfService wzItfService;


    /**
     * 新增物资工单
     *
     * @return
     */
    @RequestMapping("/wzItf/addNewWzItf")
    @ResponseBody
    public Object addNewWzItf(WzItf wzItf) {
        try {
            Map<String, Object> obj = wzItfService.addNewWzItf(wzItf);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.success("工单保存失败");
        }
    }

    /***
     * 查询全部工单信息
     * @param resultInfo 接收页面分页信息
     * @return
     */
    @RequestMapping("/wzItf/queryWzItf")
    @ResponseBody
    public Object queryWzItf(ResultInfo<WzItfVo> resultInfo) {
        PageHelper.startPage(resultInfo.getPage(), resultInfo.getLimit());
        List<WzItfVo> objects = wzItfService.queryWzItfAll();
        PageInfo<WzItfVo> pageInfo = new PageInfo<>(objects);
        if (objects != null && objects.size() > 0) {
            ResultInfo result = ResultInfo.dataInfo(0, pageInfo.getTotal(), pageInfo.getList());
            return result;
        } else {
            return ResultMsg.failure("没有数据");
        }
    }

    /***
     * 根据工单id查询工单信息
     * @return
     */
    @RequestMapping("/wzItf/queryWzItf/{id}")
    @ResponseBody
    public Object queryWzItfById(@PathVariable("id") Integer id) {
        WzItfVo wzItfVo = wzItfService.queryWzItfById(id);
        if (wzItfVo != null) {
            Map<String, Object> map = ResultMsg.successData(wzItfVo, "查询成功");
            return map;
        } else {
            return ResultMsg.failure("没有数据");
        }
    }

    /***
     * 根据工单id查询物资信息
     * @param resultInfo 接收页面分页信息
     * @return
     */
    @RequestMapping("/wzItf/queryWzItDetailedById/{id}")
    @ResponseBody
    public Object queryWzItDetailedById(ResultInfo<WzItfVo> resultInfo, @PathVariable("id") Integer id) {
        PageHelper.startPage(resultInfo.getPage(), resultInfo.getLimit());
        List<WzItfDetailed> wzItfDetaileds = wzItfService.queryWzItDetailedById(id);
        PageInfo<WzItfDetailed> pageInfo = new PageInfo<>(wzItfDetaileds);
        ResultInfo result = ResultInfo.dataInfo(0, pageInfo.getTotal(), pageInfo.getList());
        return result;
    }

    /***
     * 根据工单id查询线路信息
     * @param resultInfo 接收页面分页信息
     * @return
     */
    @RequestMapping("/wzItf/queryWzWorkLineById/{id}")
    @ResponseBody
    public Object queryWzWorkLineById(ResultInfo<WzItfVo> resultInfo, @PathVariable("id") Integer id) {
        PageHelper.startPage(resultInfo.getPage(), resultInfo.getLimit());
        List<WzWorkLine> wzWorkLines = wzItfService.queryWzWorkLineById(id);
        PageInfo<WzWorkLine> pageInfo = new PageInfo<>(wzWorkLines);
        ResultInfo result = ResultInfo.dataInfo(0, pageInfo.getTotal(), pageInfo.getList());
        return result;
    }

    /**
     * 根据工单ID 复制此工单
     *
     * @param id  工单ID
     * @param num 复制数量
     * @return
     */
    @RequestMapping("/wzItf/copyWzItfGd")
    @ResponseBody
    public Object copyWzItfGd(Integer id, @RequestParam(value = "num", defaultValue = "1") Integer num) {
        try {
            int i = wzItfService.copyWzItfGd(id, num);
            return ResultMsg.success("复制成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.success("复制失败");
        }


    }


}
