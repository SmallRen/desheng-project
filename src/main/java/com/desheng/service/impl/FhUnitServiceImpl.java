package com.desheng.service.impl;

import com.desheng.mapper.FhUnitMapper;
import com.desheng.pojo.FhUnit;
import com.desheng.service.wzgd.FhUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fhUnitService")
public class FhUnitServiceImpl implements FhUnitService {

    @Autowired
    private FhUnitMapper fhUnitMapper;

    /**
     * 查询全部发货单位
     *
     * @return List<FhUnit>
     */
    @Override
    public List<FhUnit> queryFhUnitAll() {
        List<FhUnit> fhUnits = fhUnitMapper.selectByExample(null);
        return fhUnits;
    }
}
