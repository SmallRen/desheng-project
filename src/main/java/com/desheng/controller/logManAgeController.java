package com.desheng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desheng.pojo.LoginLog;
import com.desheng.pojo.User;
import com.desheng.service.user.LoginLogService;
import com.desheng.util.ResultInfo;
import com.desheng.util.shiro.ShiroUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
public class logManAgeController {
    @Autowired
    private LoginLogService loginLogService;

    //获取用户的登陆信息日志
    @RequestMapping("logManAge/loginLog")
    @ResponseBody
    public Object getloginLog(ResultInfo<LoginLog> resultInfo, LoginLog example) {
        try {
            resultInfo.setExample(example);//设置条件
            User user = ShiroUtil.copyProperties(User.class);
            // 引入pagehelper分页插件引用查询之前只需要调用，传入页码，以及每页的数据
            PageHelper.startPage(resultInfo.getPage(), resultInfo.getLimit());
            List<LoginLog> loginLogs = loginLogService.getloginLog(user.getUsername());
            // 封装了详细的分页信息，包括有我们查询出来的数据,连续显示的页数
            PageInfo<LoginLog> page = new PageInfo<>(loginLogs);
            ResultInfo result = ResultInfo.dataInfo(0, page.getTotal(), page.getList());
            return result;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return ResultInfo.dataInfo(0, 0, null);
    }
}
