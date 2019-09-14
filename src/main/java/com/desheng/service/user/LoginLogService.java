package com.desheng.service.user;

import java.util.List;

import com.desheng.pojo.LoginLog;

public interface LoginLogService {
    /**
     * 记录用户登陆 日志
     *
     * @param loginLog
     * @return
     */
    int insertUserLoginLog(LoginLog loginLog);

    /**
     * 查询当前用户的登陆日志
     *
     * @param username 用户名
     * @return
     */
    List<LoginLog> getloginLog(String username);
}
