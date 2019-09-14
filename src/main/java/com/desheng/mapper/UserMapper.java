package com.desheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.User;
import com.desheng.pojo.UserExample;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(int key);

    /**
     * 没有的字段自动插入null,没有选择性插入
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 有哪些字段插入那些字段
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    /**
     * 登陆查询
     *
     * @param example
     * @return
     */
    User selectByExampleOne(UserExample example);

    User selectByPrimaryKey(int key);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询是经理角色的人员信息
     *
     * @return
     */
    List<User> findPorjectManger();
}