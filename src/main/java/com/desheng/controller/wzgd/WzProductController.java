package com.desheng.controller.wzgd;

import com.desheng.pojo.WzProduct;
import com.desheng.service.wzgd.WzProductService;
import com.desheng.util.ResultInfo;
import com.desheng.vo.WzPointProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WzProductController {

    @Autowired
    private WzProductService wzProductService;

    @RequestMapping("wzProduct/queryWzProductAll")
    @ResponseBody
    //查询全部物资信息
    public Object queryWzProductAll() {
        List<WzProduct> wzProducts = wzProductService.queryWzProductAll();
        return ResultInfo.dataInfo(0, wzProducts.size(), wzProducts);
    }

    @RequestMapping("wzProduct/queryWzProductByName")
    @ResponseBody
    //根据能模糊查询 （还没修改sql没有匹配规格编码等）
    public Object queryWzProductByName(String name) {
        List<WzProduct> wzProducts = wzProductService.queryWzProductByName(name);
        return ResultInfo.dataInfo(0, wzProducts.size(), wzProducts);
    }

    @RequestMapping("wzProduct/queryWzPointByScode")
    @ResponseBody
    //根据能模糊查询 （还没修改sql没有匹配规格编码等）
    public Object queryWzPointByScode(String scode) {
        List<Map<String, Object>> maps = wzProductService.queryWzPointByScode(scode);
        wzProductService.queryWzPointByScode(scode);
        Map<String, Object> map = new HashMap<>();
        if (maps != null && maps.size() > 0) {
            map.put("sCode", maps.get(0).get("wz_scode"));
            map.put("line", maps);
        }
        return map;
    }

}
