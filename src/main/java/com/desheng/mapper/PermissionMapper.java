package com.desheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.Permission;
import com.desheng.pojo.PermissionExample;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据用户查询用户所对应菜单
     *
     * @param parentId
     * @param example
     * @return
     */
    List<Permission> selectByUserId(@Param("id") Integer id, @Param("parentId") int parentId);

    /**
     * 根据角色查询权限只查是按钮的
     *
     * @param rid
     * @return
     */
    List<Permission> queryPermByRid(Integer rid);

    /**
     * 查询全部菜单不包括按钮
     */
    List<Permission> selectByPermission();
}