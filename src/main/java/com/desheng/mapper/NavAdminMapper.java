package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.NavAdmin;
import com.desheng.pojo.NavAdminExample;

public interface NavAdminMapper {
    long countByExample(NavAdminExample example);

    int deleteByExample(NavAdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NavAdmin record);

    int insertSelective(NavAdmin record);

    List<NavAdmin> selectByExample(NavAdminExample example);

    NavAdmin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NavAdmin record, @Param("example") NavAdminExample example);

    int updateByExample(@Param("record") NavAdmin record, @Param("example") NavAdminExample example);

    int updateByPrimaryKeySelective(NavAdmin record);

    int updateByPrimaryKey(NavAdmin record);
}