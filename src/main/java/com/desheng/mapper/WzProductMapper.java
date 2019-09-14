package com.desheng.mapper;

import com.desheng.pojo.WzProduct;
import com.desheng.pojo.WzProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WzProductMapper {
    long countByExample(WzProductExample example);

    int deleteByExample(WzProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WzProduct record);

    int insertSelective(WzProduct record);

    List<WzProduct> selectByExample(WzProductExample example);

    WzProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WzProduct record, @Param("example") WzProductExample example);

    int updateByExample(@Param("record") WzProduct record, @Param("example") WzProductExample example);

    int updateByPrimaryKeySelective(WzProduct record);

    int updateByPrimaryKey(WzProduct record);
}