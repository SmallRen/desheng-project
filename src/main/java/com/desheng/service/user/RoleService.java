package com.desheng.service.user;

import java.util.List;

import com.desheng.pojo.Role;

public interface RoleService {
    /**
     * 查询角色信息
     *
     * @return
     */
    List<Role> queryRoleList();

    /**
     * 给角色设置权限
     *
     * @param pid
     * @param id
     * @throws Exception
     */
    void insertRoleAndPerm(String id, String[] pid) throws Exception;

    /**
     * 注册新菜单时，默认给admin拥有菜单
     *
     * @param id 注册新菜单的ID
     * @return
     */
    void insertRoleAndMenuByAdmin(String id);

    /**
     * 查询角色已拥有的权限
     *
     * @param rid 角色主键
     * @return
     */
    List<Integer> queryRolePer(Integer rid);


    /**
     * 查询角色已拥有的菜单
     *
     * @param rid 角色主键
     * @return
     */
    List<Integer> queryRoleMenu(Integer rid);

    /**
     * 给用户设置角色
     *
     * @param id  用户id
     * @param rid 角色id
     * @throws Exception
     */
    void insertUserSetRole(String id, String[] rid) throws Exception;

    /**
     * 查询用户已拥有的角色
     *
     * @param rid 用户id
     * @return
     */
    List<Integer> queryUserRole(String rid);

}
