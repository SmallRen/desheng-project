package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.Role;
import com.desheng.pojo.RoleExample;

public interface RoleMapper {
	long countByExample(RoleExample example);

	int deleteByExample(RoleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	/**
	 * 查询用户拥有的角色
	 * 
	 * @param uid
	 * @return
	 */
	List<Role> queryRoleByUid(Integer uid);
}