package com.desheng.controller;

import java.util.List;
import java.util.Map;

import com.desheng.pojo.Permission;
import com.desheng.pojo.Role;
import com.desheng.pojo.User;
import com.desheng.rabbitmq.config.config.RabbitMqConfig;
import com.desheng.rabbitmq.config.sender.FirstSender;
import com.desheng.service.menu.MenuService;
import com.desheng.service.user.RoleService;
import com.desheng.service.user.UserService;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;
import com.desheng.util.shiro.ShiroUtil;
import com.google.code.kaptcha.Constants;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    // @Autowired
    // private FirstSender firstSender;
    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/login")
    @ResponseBody
    public Object getUserLogin(String username, String password, String vercode, String app, HttpSession session) {


        if (StringUtils.isBlank(password) || StringUtils.isBlank(username)) {
            return ResultMsg.failure("账号或密码不能为空！");
        }
        if (app == null) { //不是app请求才校验
            // 验证码校验
            if (StringUtils.isBlank(vercode)) {
                return ResultMsg.failure("验证码不能为空！");
            }
            Object key = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (!vercode.equalsIgnoreCase(key.toString())) {
                return ResultMsg.failure("验证码错误！");
            }
        }
        // 1.创建Subject实例
        Subject currentUser = SecurityUtils.getSubject();
        // 2.判断当前用户是否登陆
        // 调用Subject的isAuthenticated
        if (!currentUser.isAuthenticated()) {
            // 3.将用户名及密码封装到指定的UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // token.setRememberMe(true);会在前台生成cookie
            try {
                currentUser.login(token);
                // return ResultMsg.success("登陆成功");
                log.info("用户 [" + currentUser.getPrincipal() + "] 登陆成功");
                return ResultMsg.success("登陆成功");
                //return "redirect:/index";
            } catch (LockedAccountException e) {
                log.info(e.getMessage());

            } catch (AuthenticationException e) {
                log.info("用户 未登录");
                return ResultMsg.failure("帐号或密码错误");
            }
        } else {
            //用户已经登陆直接跳转主页
            return ResultMsg.success("登陆成功");
            //return "redirect:/index";
        }
        return ResultMsg.failure("登陆失败");
        // return "redirect:/login";
    }

    @RequestMapping("/register")
    @ResponseBody
    public Map<String, Object> inserRegister(User user) {
        // 1.判断用户是否已经注册
        boolean isUser = userService.queryIsUser(user.getUsername());
        //通过消息队列发送信息到邮箱
        // firstSender.send(RabbitMqConfig.EXCHANGE, RabbitMqConfig.QUEUEEMAILKEY, user);
        if (isUser) {
            Object object = user;
            user.setPassword(ShiroUtil.SysMd5(user.getUsername(), user.getPassword()));
            user.setSalt(user.getUsername());// 以用户名作为盐值
            return userService.insertUser(user);
        }
        return ResultMsg.failure("账号已经注册");
    }

    @RequestMapping("/userList")
    @ResponseBody
    public Object queryUserList() {
        ResultInfo result = new ResultInfo();
        List<User> listUser = userService.queryListUser();
        result.setCode(0);
        result.setCount(listUser.size());
        result.setMsg("成功");
        result.setData(listUser);
        return result;
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public Object queryRoleList() {
        ResultInfo result = new ResultInfo();
        List<Role> roleUser = roleService.queryRoleList();
        result.setCode(0);
        result.setCount(roleUser.size());
        result.setMsg("成功");
        result.setData(roleUser);
        return result;
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public Object queryMenuList() {
        ResultInfo result = new ResultInfo();
        List<Permission> permissions = menuService.queryMenuList();
        result.setData(permissions);
        return permissions;
    }
}
