package com.desheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.desheng.mapper.PermissionMapper;
import com.desheng.pojo.Permission;
import com.desheng.service.menu.MenuService;
import com.desheng.service.user.RoleService;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public List<Permission> queryMenuList() {
        List<Permission> permissions = permissionMapper.selectByPermission();
        return permissions;
    }

    @Override
    public int updatePermission(Permission permission) {
        int i = permissionMapper.updateByPrimaryKeySelective(permission);
        return i;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public int addPermission(Permission permission) throws Exception{
        int i = permissionMapper.insertSelective(permission);
        if (i > 0) {
            roleService.insertRoleAndMenuByAdmin(permission.getId().toString());
        }
        return i;
    }

    @Override
    public int delPermission(Integer id) {
        int i = permissionMapper.deleteByPrimaryKey(id);
        return i;
    }
}
