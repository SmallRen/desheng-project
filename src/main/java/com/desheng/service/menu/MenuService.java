package com.desheng.service.menu;

import java.util.List;

import com.desheng.pojo.Permission;

public interface MenuService {
    /**
     * 查询菜单
     *
     * @return
     */
    List<Permission> queryMenuList();

    /**
     * 更新菜单
     *
     * @param permission
     * @return
     */
    int updatePermission(Permission permission);

    /**
     * 新增菜单
     *
     * @param permission
     * @return
     */
    int addPermission(Permission permission) throws Exception;

    /**
     * 删除菜单
     *
     * @param  id
     * @return
     */
    int delPermission(Integer  id);
}
