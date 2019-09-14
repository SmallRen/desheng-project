package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.LeaveInfoUser;
import com.desheng.pojo.LeaveInfoUserExample;
import com.desheng.pojo.LeaveInfoUserKey;

public interface LeaveInfoUserMapper {
    long countByExample(LeaveInfoUserExample example);

    int deleteByExample(LeaveInfoUserExample example);

    int deleteByPrimaryKey(LeaveInfoUserKey key);

    int insert(LeaveInfoUser record);

    int insertSelective(LeaveInfoUser record);

    List<LeaveInfoUser> selectByExample(LeaveInfoUserExample example);

    LeaveInfoUser selectByPrimaryKey(LeaveInfoUserKey key);

    int updateByExampleSelective(@Param("record") LeaveInfoUser record, @Param("example") LeaveInfoUserExample example);

    int updateByExample(@Param("record") LeaveInfoUser record, @Param("example") LeaveInfoUserExample example);

    int updateByPrimaryKeySelective(LeaveInfoUser record);

    int updateByPrimaryKey(LeaveInfoUser record);
}