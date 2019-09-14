package com.desheng.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desheng.pojo.NavAdmin;
import com.desheng.pojo.Role;
import com.desheng.pojo.User;
import com.desheng.service.menu.NavService;
import com.desheng.service.user.RoleService;
import com.desheng.shiro.MyShiroRealm;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;
import com.desheng.vo.TableNode;
import com.desheng.vo.TreeNode;
import com.desheng.vo.TreeNodeSides;

@Controller
@RequestMapping("main")
public class MainController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private NavService navService;
    @Autowired
    private RoleService roleService;

    @Value("${NAME}")
    private String NAME;

    // 获取导航栏菜单
    @RequestMapping("/navs")
    @ResponseBody
    public List<?> getAllNva() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        User user = new User();
        try {
            BeanUtils.copyProperties(user, principal);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        List<?> navAll = navService.getNavAll(user.getId(), 0);
        return navAll;
    }

    // 查询全部权限tree
    @RequestMapping("/tree")
    @ResponseBody
    @RequiresPermissions("perm:adds")
    public List<?> getTreeAll(@RequestParam(value = "rid", defaultValue = "0") Integer rid) {
        List<Integer> queryRolePer = roleService.queryRolePer(rid);
        List<TreeNodeSides> navAll = navService.getTreeAll(0);
        List<TreeNodeSides> list = treeEach(navAll, queryRolePer);
        log.info(list.toString());
        return list;
    }

    //查询全部菜单 暂时不用
    @RequestMapping("/allotMenu")
    @ResponseBody
    public List<?> allotMenu(@RequestParam(value = "rid", defaultValue = "0") Integer rid) {
        List<Integer> queryRoleMenu = roleService.queryRoleMenu(rid);
        List<TreeNodeSides> navAll = navService.getTreeAllByMenu(0);
        List<TreeNodeSides> list = treeEach(navAll, queryRoleMenu);
        log.info(list.toString());
        return list;
    }

    /**
     * 遍历 如果角色已有这个权限，设置为true，前台复选框就会勾选
     *
     * @param navAll
     * @param queryRolePer
     * @return
     */
    private List<TreeNodeSides> treeEach(List<TreeNodeSides> navAll, List<Integer> queryRolePer) {
        for (TreeNodeSides treeNode : navAll) {
            if (treeNode.getData().size() > 0) {
                for (TreeNodeSides tree : treeEach(treeNode.getData(), queryRolePer)) {
                    if (queryRolePer.contains(tree.getValue())) {
                        tree.setChecked(true);
                    } else {
                        tree.setChecked(false);
                    }
                }
            }
            if (queryRolePer.contains(treeNode.getValue())) {
                treeNode.setChecked(true);
            } else {
                treeNode.setChecked(false);
            }
        }
        return navAll;
    }

    // 删除角色
    @RequestMapping("main/delete_role")
    @ResponseBody
    @RequiresPermissions("perm:delete_role")
    public List<?> deleteRole(@RequestParam(value = "rid", defaultValue = "0") Integer rid) {

        return null;
    }

    /**
     * @param id  角色id
     * @param pid 所拥有的权限
     */
    @RequestMapping("/permission")
    @ResponseBody
    public Map<String, Object> permission(@RequestParam(value = "id") String id,
                                          @RequestParam(value = "pid[]", defaultValue = "0") String[] pid) {
        try {
            roleService.insertRoleAndPerm(id, pid);
            //取出对象
            DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
            MyShiroRealm myShiroRealm = (MyShiroRealm) securityManager.getRealms().iterator().next();
            //清理缓存
            myShiroRealm.clearAllCache();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.success("设置权限失败");
        }

        return ResultMsg.success("设置权限成功");
    }

    /**
     * 给用户设置角色
     *
     * @param id  用户id
     * @param rid 角色的ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/userSetRole")
    public Map<String, Object> userSetRole(@RequestParam(value = "id") String id,
                                           @RequestParam(value = "rid[]", defaultValue = "0") String[] rid) {

        try {
            roleService.insertUserSetRole(id, rid);
            //取出对象
            DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
            MyShiroRealm myShiroRealm = (MyShiroRealm) securityManager.getRealms().iterator().next();
            //清理缓存
            myShiroRealm.clearAllCache();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.success("设置角色失败");
        }

        return ResultMsg.success("设置角色成功");
    }

    /**
     * 查询全部用户
     *
     * @return
     */
    @RequestMapping("/roleList")
    @ResponseBody
    public Object queryUserList(@RequestParam("rid") String rid) {
        List<Role> roleUser = roleService.queryRoleList();
        List<Integer> queryUserRole = roleService.queryUserRole(rid);
        List<TableNode> tableNodes = new ArrayList<TableNode>();
        for (Role role : roleUser) {
            TableNode table = new TableNode();
            table.setId(role.getId());
            table.setDescription(role.getDescription());
            table.setName(role.getName());
            table.setStatus(role.getStatus());
            table.setChecked(queryUserRole.contains(role.getId()));
            tableNodes.add(table);
        }
        ResultInfo result = new ResultInfo();
        result.setCode(0);
        result.setCount(tableNodes.size());
        result.setMsg("成功");
        result.setData(tableNodes);
        return result;
    }

    /**
     * 菜单管理显示全部菜单，并且分页，默认easyui会传两个参数
     *
     * @param page 第几页
     * @param rows 每页显示的条数
     * @return
     */
    @PostMapping("/getnavsAll.do")
    @ResponseBody
    public Map<String, Object> getAllNvas(Integer page, Integer rows) {
        Map<String, Object> navAll = navService.getNavAlls(page, rows);
        return navAll;
    }

    /**
     * 添加一个新菜单
     *
     * @param navAdmin
     * @return
     */
    @PostMapping("/addSave")
    @ResponseBody
    public boolean addNavAdmin(NavAdmin navAdmin) {
        boolean b = navService.addNav(navAdmin);
        return b;

    }

    /**
     * 查询一级菜单
     *
     * @return
     */
    @RequestMapping("/getparent")
    @ResponseBody
    public List<NavAdmin> getParent() {
        List<NavAdmin> list = navService.getParent();
        return list;
    }

    @DeleteMapping("/deleteMaun/{ids}")
    @ResponseBody
    public boolean deleteMaun(@PathVariable("ids") String[] ids) {
        boolean b = navService.deleteMaun(ids);
        return b;

    }
}
