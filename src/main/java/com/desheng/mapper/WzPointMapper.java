package com.desheng.mapper;

import com.desheng.pojo.WzPoint;
import com.desheng.pojo.WzPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WzPointMapper {
    long countByExample(WzPointExample example);

    int deleteByExample(WzPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WzPoint record);

    int insertSelective(WzPoint record);

    List<WzPoint> selectByExample(WzPointExample example);

    WzPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WzPoint record, @Param("example") WzPointExample example);

    int updateByExample(@Param("record") WzPoint record, @Param("example") WzPointExample example);

    int updateByPrimaryKeySelective(WzPoint record);

    int updateByPrimaryKey(WzPoint record);
}