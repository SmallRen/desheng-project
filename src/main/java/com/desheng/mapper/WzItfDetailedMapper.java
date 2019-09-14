package com.desheng.mapper;

import com.desheng.pojo.WzItfDetailed;
import com.desheng.pojo.WzItfDetailedExample;
import com.desheng.pojo.WzItfDetailedKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WzItfDetailedMapper {
    long countByExample(WzItfDetailedExample example);

    int deleteByExample(WzItfDetailedExample example);

    int deleteByPrimaryKey(WzItfDetailedKey key);

    int insert(WzItfDetailed record);

    int insertSelective(WzItfDetailed record);

    List<WzItfDetailed> selectByExample(WzItfDetailedExample example);

    WzItfDetailed selectByPrimaryKey(WzItfDetailedKey key);

    int updateByExampleSelective(@Param("record") WzItfDetailed record, @Param("example") WzItfDetailedExample example);

    int updateByExample(@Param("record") WzItfDetailed record, @Param("example") WzItfDetailedExample example);

    int updateByPrimaryKeySelective(WzItfDetailed record);

    int updateByPrimaryKey(WzItfDetailed record);
}