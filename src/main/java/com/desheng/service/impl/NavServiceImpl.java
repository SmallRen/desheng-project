package com.desheng.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desheng.mapper.NavAdminMapper;
import com.desheng.mapper.PermissionMapper;
import com.desheng.pojo.NavAdmin;
import com.desheng.pojo.NavAdminExample;
import com.desheng.pojo.Permission;
import com.desheng.pojo.PermissionExample;
import com.desheng.service.menu.NavService;
import com.desheng.vo.TitleNode;
import com.desheng.vo.TreeNodeSides;

@Service("navService")
public class NavServiceImpl implements NavService {

    @Autowired
    private NavAdminMapper navAdminMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<?> getNavAll(Integer id, Integer pid) {
        List<Permission> list = permissionMapper.selectByUserId(id, pid);
        List<TitleNode> resultList = new ArrayList<TitleNode>();
        for (Permission menu : list) {
            TitleNode titleNode = new TitleNode();
            titleNode.setName(menu.getName());
            titleNode.setUrl(menu.getUrl());
            titleNode.setIcon(menu.getIcon());
            titleNode.setStatus(menu.getStatus() == 1 ? true : false);
            titleNode.setId(menu.getId());
            titleNode.setTitleNode(getNavAll(id, menu.getId()));
            resultList.add(titleNode);
        }
        return resultList;
    }

    /**
     * 查询全部权限
     */
    @Override
    public List<TreeNodeSides> getTreeAll(Integer id) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andParentIdEqualTo(id);
        List<Permission> list = permissionMapper.selectByExample(example);
        List<TreeNodeSides> resultList = TreeNodeSides(list);
        return resultList;
    }

    /**
     * 暂时不用
     */
    @Override
    public List<TreeNodeSides> getTreeAllByMenu(Integer id) {
        PermissionExample example = new PermissionExample();
        //查询不是按钮的菜单
        example.createCriteria().andParentIdEqualTo(id).andTypeLessThanOrEqualTo(2);
        List<Permission> list = permissionMapper.selectByExample(example);
        List<TreeNodeSides> resultList = TreeNodeSides(list);
        return resultList;
    }

    private List<TreeNodeSides> TreeNodeSides(List<Permission> list) {
        List<TreeNodeSides> resultList = new ArrayList<TreeNodeSides>();
        if (list != null && list.size() > 0) {
            for (Permission menu : list) {
                TreeNodeSides titleNode = new TreeNodeSides();
                titleNode.setValue(menu.getId());
                titleNode.setTitle(menu.getName());
                titleNode.setType(menu.getType());
                titleNode.setData(getTreeAll(menu.getId()));
                resultList.add(titleNode);
            }
        }
        return resultList;
    }

    @Override
    public Map<String, Object> getNavAlls(Integer page, Integer rows) {

        // 算出每页的起始索引
        int startIndex = (page - 1) * rows;
        NavAdminExample example = new NavAdminExample();
        // example.setStartRow(startIndex);
        // example.setPageSize(rows);
        List<NavAdmin> list = navAdminMapper.selectByExample(example);
        // int selectNum = navAdminMapper.selectNum();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        // map.put("total", selectNum);
        return map;
    }

    @Override
    public boolean addNav(NavAdmin navAdmin) {
        int i = navAdminMapper.insertSelective(navAdmin);
        // System.out.println("iiiiiiiiiiiiiiii" + i);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<NavAdmin> getParent() {
        NavAdminExample example = new NavAdminExample();
        example.createCriteria().andParentIdEqualTo(Long.valueOf(0));
        List<NavAdmin> list = navAdminMapper.selectByExample(example);
        return list;
    }

    @Override
    public boolean deleteMaun(String[] ids) {
        boolean b = true;
        try {
            for (String id : ids) {
                navAdminMapper.deleteByPrimaryKey(Long.valueOf(id));
            }
        } catch (NumberFormatException e) {
            b = false;
            throw new RuntimeException();
        }
        return b;
    }

}
