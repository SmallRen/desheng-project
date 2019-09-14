package com.desheng.service.menu;

import java.util.List;
import java.util.Map;

import com.desheng.pojo.NavAdmin;
import com.desheng.vo.TreeNodeSides;

public interface NavService {

    /**
     * 根据parentid父节点下的获取导航栏菜单
     *
     * @param id  用户id
     * @param pid 权限的id （通过id查询parent_id = id 的权限）
     * @return
     */
    List<?> getNavAll(Integer id, Integer pid);

    /**
     * 查询全部菜单tree
     *
     * @return
     */
    List<TreeNodeSides> getTreeAll(Integer id);

    /**
     * 查询全部菜单只是菜单不包括按钮
     *
     * @param id 默认0一级菜单开始遍历
     * @return
     */
    List<TreeNodeSides> getTreeAllByMenu(Integer id);

    /**
     * 获取全部导航栏菜单
     *
     * @return
     */
    Map<String, Object> getNavAlls(Integer page, Integer rows);

    /**
     * 添加一个新菜单
     *
     * @param navAdmin
     * @return
     */
    boolean addNav(NavAdmin navAdmin);

    /**
     * 查询一级菜单
     *
     * @return
     */
    List<NavAdmin> getParent();

    /**
     * 根据id批量删除菜单
     *
     * @param id
     * @return
     */
    boolean deleteMaun(String[] ids);

}
