package com.desheng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import com.desheng.util.ResultMsg;
import com.desheng.util.WebUtilsPro;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 认证 授权  ，异常 没有权限提示信息
 *
 * @author wu_lei
 */
public abstract class BaseController {
    /**
     * 登录认证异常
     */
    @ExceptionHandler({UnauthenticatedException.class, AuthenticationException.class,
            IncorrectCredentialsException.class})
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
        if (WebUtilsPro.isAjaxRequest(request)) {
            // 输出JSON
            Map<String, Object> map = ResultMsg.failure("登陆失败重新登陆");
            writeJson(map, response);
            return null;
        } else {
            return "redirect:/";
        }
    }

    /**
     * 权限异常
     */
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class, Unauthorized.class})
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        if (WebUtilsPro.isAjaxRequest(request)) {//判断是否是Ajax请求
            // 输出JSON
            Map<String, Object> map = ResultMsg.failure("你没有权限");
            writeJson(map, response);
            return null;
        } else {
            return "redirect:/page/403";
        }
    }

    /**
     * 输出JSON
     *
     * @param response
     * @author SHANHY
     * @create 2017年4月4日
     */
    private void writeJson(Map<String, Object> map, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
