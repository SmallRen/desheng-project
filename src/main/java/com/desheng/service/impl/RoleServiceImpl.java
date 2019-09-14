package com.desheng.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.desheng.mapper.RoleMapper;
import com.desheng.mapper.RolePermissionMapper;
import com.desheng.mapper.UserRoleMapper;
import com.desheng.pojo.*;
import com.desheng.pojo.RolePermissionExample.Criteria;
import com.desheng.service.user.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleMapper")
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> queryRoleList() {
        List<Role> list = roleMapper.selectByExample(null);
        return list;
    }

    /**
     * 查询用户已拥有的权限
     *
     * @param rid 角色主键
     */
    @Override
    public List<Integer> queryRolePer(Integer rid) {
        List<Integer> byRid = rolePermissionMapper.queryRolePermissionByRid(rid);
        return byRid;
    }

    /**
     * 查询用户已拥有的菜单
     *
     * @param rid 角色主键
     * @return
     */
    @Override
    public List<Integer> queryRoleMenu(Integer rid) {
        return rolePermissionMapper.queryRoleMenuByRid(rid);
    }

    /**
     * 设置权限
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public void insertRoleAndPerm(String id, String[] pid) throws Exception {
        // 设置权限时，先把这个角色拥有权限都删除
        RolePermissionExample rolePer = new RolePermissionExample();
        Criteria criteria = rolePer.createCriteria();
        criteria.andRoleIdEqualTo(id);
        rolePermissionMapper.deleteByExample(rolePer);
        if (!"0".equals(pid[0])) {
            for (String p : pid) {
                RolePermission record = new RolePermission();
                record.setRoleId(id);
                record.setPermissionId(p);
                rolePermissionMapper.insertSelective(record);
            }
        }
    }

    @Override
    public void insertRoleAndMenuByAdmin(String id) {

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo("admin");
        List<Role> roles = roleMapper.selectByExample(roleExample);

        if (roles.size() > 0) {
            for (Role role : roles) {
                RolePermission record = new RolePermission();
                record.setRoleId(role.getId().toString());
                record.setPermissionId(id);
                rolePermissionMapper.insertSelective(record);
            }
        }
    }

    /**
     * 给用户设置角色
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public void insertUserSetRole(String id, String[] rid) throws Exception {
        // 设置角色时，先把用户锁拥有的角色都删除
        UserRoleExample userRole = new UserRoleExample();
        userRole.createCriteria().andUserIdEqualTo(id);
        userRoleMapper.deleteByExample(userRole);
        if (!"0".equals(rid[0])) {
            for (String r : rid) {
                UserRole ur = new UserRole();
                ur.setUserId(id);
                ur.setRoleId(r);
                userRoleMapper.insertSelective(ur);
            }
        }
    }

    @Override
    public List<Integer> queryUserRole(String rid) {
        return userRoleMapper.queryUserRoleByRid(rid);
    }

}
