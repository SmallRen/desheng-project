package com.desheng.controller.wzgd;

import com.desheng.pojo.FhUnit;
import com.desheng.service.wzgd.FhUnitService;
import com.desheng.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FhUnitController {
    @Autowired
    private FhUnitService fhUnitService;

    //查询发货单位，
    @RequestMapping("fhUnit/getFhUnitAll")
    @ResponseBody
    public Object getFhUnitAll() {
        List<FhUnit> fhUnits = fhUnitService.queryFhUnitAll();
        return ResultMsg.successData(fhUnits, "查询成功");
    }
}
