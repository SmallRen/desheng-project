package com.desheng.aspect;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.desheng.pojo.LoginLog;
import com.desheng.pojo.User;
import com.desheng.service.user.LoginLogService;
import com.desheng.util.IpUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Aspect
public class LogAspect {
    private static Logger log = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private LoginLogService loginLogService;

    public LogAspect() {
        log.info("通知注入");
    }

    /**
     * 管理员登录方法的切入点
     */
    @Pointcut("execution(* com.petroleum.controller.UserController.getUserLogin(..))")
    public void loginCell() {
    }

    /**
     * 方法return 后通知
     *
     * @param joinPoint
     * @param object    是方法返回的值
     * @throws Throwable
     */
    @AfterReturning(value = "loginCell()", returning = "object")
    public void loginLog(JoinPoint joinPoint, Object object) throws Throwable {
        //获取通知方法名
        String methodName = joinPoint.getSignature().getName();
        //获取方法里面的参数
        Object[] args = joinPoint.getArgs();
        for (Object o : args) {
            log.info(o.toString());
        }
        LoginLog loginLog=new LoginLog();
        Object principal = SecurityUtils.getSubject().getPrincipal();
        //判断是否登陆成功
        if (principal!=null){
            User user = new User();
            BeanUtils.copyProperties(user, principal);
            loginLog.setStatus(1);
            loginLog.setUsername(user.getUsername());
        }else{
            //没有登陆成功就拿第一参数
            loginLog.setUsername(args[0].toString());
            loginLog.setStatus(0);
        }
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  ((ServletRequestAttributes) requestAttributes).getRequest();

        loginLog.setCreateTime(new Date());
        loginLog.setIp(IpUtils.getIpAddr(request));
        loginLog.setUserAgent(request.getHeader("User-Agent"));
        loginLogService.insertUserLoginLog(loginLog);
        log.info(methodName);
        log.info(object.toString());
        log.info("登陆后通知啊");
    }
}
