package com.desheng.service.wzgd;

import com.desheng.pojo.WzProduct;
import com.desheng.vo.WzPointProductVo;

import java.util.List;
import java.util.Map;

/**
 * 物资档案
 */
public interface WzProductService {
    /**
     * 查询全部 物资信息
     *
     * @return
     */
    List<WzProduct> queryWzProductAll();

    /**
     * 根据 名称 模糊查询(包括匹配物资规格)
     *
     * @param name
     * @return
     */
    List<WzProduct> queryWzProductByName(String name);


    /**
     * 根据物资编码查询 点位
     *
     * @param scode
     * @return
     */
    List<Map<String, Object>> queryWzPointByScode(String scode);


}
