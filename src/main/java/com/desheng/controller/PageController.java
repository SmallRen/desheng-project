package com.desheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    // 登陆页面
    @RequestMapping({"/", "login"})
    public String loginPage() {
        return "login";
    }

    // 注册页面
    @RequestMapping("register")
    public String register() {
        return "register";
    }

    // 首面
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    // 控制台页面
    @RequestMapping("page/myMsgCenter")
    public String myConsole() {
        return "myMsgCenter";
    }

    // 未授权页面
    @RequestMapping("page/403")
    public String notAuthorized() {
        return "403";
    }

    // 错误页面
    @RequestMapping("page/errors")
    public String error() {
        return "errors";
    }


    // 后台首页
    @RequestMapping("page/main")
    public String mainPage() {
        return "main";
    }

    // treetable
    @RequestMapping("page/treetable")
    public String meunPage() {
        return "atree";
    }

    // 点击查看用戶跳转用户选项卡
    @RequestMapping("page/userPage")
    public String userList() {
        return "userList";
    }

    // 点击查看个人信息页面
    @RequestMapping("page/myInfo")
    public String myInfo() {
        return "myInfo";
    }

    // 点击设置权限跳转权限选项卡
    @RequestMapping("page/rolePage")
    public String roleList() {
        return "roleList";
    }

    //点击查看菜单信息页面
    @RequestMapping("/page/menuPage")
    public String menuPage() {
        return "menuList";
    }


    //========================== 日志模块==========================
    //登陆日志
    @RequestMapping("page/logManAge/loginLog")
    public String loginLog() {
        return "loginLog";
    }

    //======================工作流模块=======================
    @RequestMapping("page/modeactiviti")
    //模型页面
    public String modeActiviti() {
        return "modeList";
    }

    //==================我的任务模块==========================
    @RequestMapping("page/myTask")
    public String myTaskList() {
        return "myTaskList";
    }

    //===================消息管理模块=========================
    //发送邮件模板
    @RequestMapping("page/noteService/sendEmail")
    public String sendEmail() {
        return "sendEmail";
    }

    //======================定时任务模块===========================
    @RequestMapping("page/system/quartz")
    public String quartzJob() {
        return "quartzJob";
    }

    //======================文件上传页面==========================
    @RequestMapping("page/system/fileUpload")
    public String fileUpload() {
        return "fileUpload";
    }

    //======================车辆登记页面==========================
    @RequestMapping("page/vehicleInfo")
    public String vehicleInfo() {
        return "vehicleInfo";
    }

    //======================车辆登记页面==========================
    @RequestMapping("page/manage/newCartTask")
    //派车单列表页面 open窗口弹出新增iframe
    public String manageNewTask() {
        return "newCartTask";
    }


    @RequestMapping("/page/manage/editCartTask")
    //派车单列表页面 open窗口弹出修改iframe
    public String manageEditask() {
        return "editCartTask";
    }

    //派车单列表页面
    @RequestMapping("page/manage/cartTaskList")
    public String cartTaskList() {
        return "cartTaskList";
    }
}
