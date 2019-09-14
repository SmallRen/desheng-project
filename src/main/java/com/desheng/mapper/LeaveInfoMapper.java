package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.LeaveInfo;
import com.desheng.pojo.LeaveInfoExample;

public interface LeaveInfoMapper {
    long countByExample(LeaveInfoExample example);

    int deleteByExample(LeaveInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LeaveInfo record);

    int insertSelective(LeaveInfo record);

    List<LeaveInfo> selectByExample(LeaveInfoExample example);

    LeaveInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LeaveInfo record, @Param("example") LeaveInfoExample example);

    int updateByExample(@Param("record") LeaveInfo record, @Param("example") LeaveInfoExample example);

    int updateByPrimaryKeySelective(LeaveInfo record);

    int updateByPrimaryKey(LeaveInfo record);
}