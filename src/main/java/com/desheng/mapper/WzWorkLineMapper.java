package com.desheng.mapper;

import com.desheng.pojo.WzWorkLine;
import com.desheng.pojo.WzWorkLineExample;
import com.desheng.pojo.WzWorkLineKey;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WzWorkLineMapper {
    long countByExample(WzWorkLineExample example);

    int deleteByExample(WzWorkLineExample example);

    int deleteByPrimaryKey(WzWorkLineKey key);

    int insert(WzWorkLine record);

    int insertSelective(WzWorkLine record);

    List<WzWorkLine> selectByExample(WzWorkLineExample example);

    WzWorkLine selectByPrimaryKey(WzWorkLineKey key);

    int updateByExampleSelective(@Param("record") WzWorkLine record, @Param("example") WzWorkLineExample example);

    int updateByExample(@Param("record") WzWorkLine record, @Param("example") WzWorkLineExample example);

    int updateByPrimaryKeySelective(WzWorkLine record);

    int updateByPrimaryKey(WzWorkLine record);

    int insertSelectiveMap(Map<String, Object> map);

}