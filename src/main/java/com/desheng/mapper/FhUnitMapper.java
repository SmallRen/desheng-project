package com.desheng.mapper;

import com.desheng.pojo.FhUnit;
import com.desheng.pojo.FhUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FhUnitMapper {
    long countByExample(FhUnitExample example);

    int deleteByExample(FhUnitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FhUnit record);

    int insertSelective(FhUnit record);

    List<FhUnit> selectByExample(FhUnitExample example);

    FhUnit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FhUnit record, @Param("example") FhUnitExample example);

    int updateByExample(@Param("record") FhUnit record, @Param("example") FhUnitExample example);

    int updateByPrimaryKeySelective(FhUnit record);

    int updateByPrimaryKey(FhUnit record);
}