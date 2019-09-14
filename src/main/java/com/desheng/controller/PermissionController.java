package com.desheng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desheng.pojo.Permission;
import com.desheng.service.menu.MenuService;
import com.desheng.util.ResultMsg;

import java.util.Map;


@Controller
@RequestMapping(("permission"))
public class PermissionController {
    private static Logger log = LoggerFactory.getLogger(PermissionController.class);
    @Autowired
    private MenuService menuService;

    @RequestMapping("/updatePermission")
    @ResponseBody
    public Map<String, Object> updatePermission(Permission permission) {
        log.info("打印" + permission);
        int i = menuService.updatePermission(permission);
        if (i > 0) {
            return ResultMsg.success("更新菜单成功");
        } else {
            return ResultMsg.success("更新菜单失败");
        }
    }

    @RequestMapping("/addPermission")
    @ResponseBody
    public Map<String, Object> addPermission(Permission permission) {
        log.info("打印" + permission);
        int i = 0;
        try {
            i = menuService.addPermission(permission);
            if (i > 0) {
                return ResultMsg.success("新增菜单成功");
            } else {
                return ResultMsg.success("新增菜单失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultMsg.success("新增菜单失败");
        }
    }

    @RequestMapping("/delPermission/{ids}")
    @ResponseBody
    public Map<String, Object> delPermission(@PathVariable("ids") String ids) {
        log.info("打印" + ids);
        int i = 0;//menuService.delPermission(id);
        if (ids.contains(",")) {
            String[] split = ids.split(",");
            for (String id : split) {
                i = menuService.delPermission(Integer.valueOf(id));
            }
        } else {
            i = menuService.delPermission(Integer.valueOf(ids));
        }
        if (i > 0) {
            return ResultMsg.success("删除菜单成功");
        } else {
            return ResultMsg.success("删除菜单失败");
        }
    }
}
