package com.desheng.service.wzgd;

import com.desheng.pojo.FhUnit;

import java.util.List;

public interface FhUnitService {
    /**
     * 查询全部发货单位
     *
     * @return List<FhUnit>
     */
    List<FhUnit> queryFhUnitAll();
}
