package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.SysJob;
import com.desheng.pojo.SysJobExample;
import com.desheng.pojo.SysJobKey;

public interface SysJobMapper {
    long countByExample(SysJobExample example);

    int deleteByExample(SysJobExample example);

    int deleteByPrimaryKey(SysJobKey key);

    int insert(SysJob record);

    int insertSelective(SysJob record);

    List<SysJob> selectByExample(SysJobExample example);

    SysJob selectByPrimaryKey(SysJobKey key);

    int updateByExampleSelective(@Param("record") SysJob record, @Param("example") SysJobExample example);

    int updateByExample(@Param("record") SysJob record, @Param("example") SysJobExample example);

    int updateByPrimaryKeySelective(SysJob record);

    int updateByPrimaryKey(SysJob record);
}