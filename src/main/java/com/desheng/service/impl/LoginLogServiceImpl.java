package com.desheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desheng.mapper.LoginLogMapper;
import com.desheng.pojo.LoginLog;
import com.desheng.pojo.LoginLogExample;
import com.desheng.service.user.LoginLogService;

import java.util.List;

@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public int insertUserLoginLog(LoginLog loginLog) {
        int i = loginLogMapper.insertSelective(loginLog);
        return i;
    }

    @Override
    public List<LoginLog> getloginLog(String username) {
        LoginLogExample loginLogExample = new LoginLogExample();
        loginLogExample.createCriteria().andUsernameEqualTo(username);
        List<LoginLog> loginLogs = loginLogMapper.selectByExample(loginLogExample);
        return loginLogs;
    }
}
