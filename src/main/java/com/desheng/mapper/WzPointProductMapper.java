package com.desheng.mapper;

import com.desheng.pojo.WzPointProduct;
import com.desheng.pojo.WzPointProductExample;

import java.util.List;
import java.util.Map;

import com.desheng.vo.WzPointProductVo;
import org.apache.ibatis.annotations.Param;

public interface WzPointProductMapper {
    long countByExample(WzPointProductExample example);

    int deleteByExample(WzPointProductExample example);

    int insert(WzPointProduct record);

    int insertSelective(WzPointProduct record);

    List<WzPointProduct> selectByExample(WzPointProductExample example);

    int updateByExampleSelective(@Param("record") WzPointProduct record, @Param("example") WzPointProductExample example);

    int updateByExample(@Param("record") WzPointProduct record, @Param("example") WzPointProductExample example);

    /**
     * 根据物资编码查询 点位
     *
     * @param scode
     * @return
     */
    List<Map<String, Object>> queryWzPointByScode(String scode);

}