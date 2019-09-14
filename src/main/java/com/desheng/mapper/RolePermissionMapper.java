package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.RolePermission;
import com.desheng.pojo.RolePermissionExample;

public interface RolePermissionMapper {
    long countByExample(RolePermissionExample example);

    int deleteByExample(RolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExample(RolePermissionExample example);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

	List<Integer> queryRolePermissionByRid(Integer rid);

    /**
     * 根据角色id查询所拥有的菜单
     * @param rid 角色id
     * @return
     */
    List<Integer> queryRoleMenuByRid(Integer rid);
    
}