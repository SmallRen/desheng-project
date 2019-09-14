package com.desheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.desheng.mapper.SysJobLogMapper;
import com.desheng.pojo.SysJobLog;
import com.desheng.service.quartz.ISysJobLogService;

@Service("iSysJobLogService")
public class ISysJobLogServiceImpl implements ISysJobLogService {


    @Autowired
    private SysJobLogMapper sysJobLogMapper;

    /**
     * 记录工作日志
     *
     * @param sysJobLog
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void addJobLog(SysJobLog sysJobLog) {
        sysJobLogMapper.insertSelective(sysJobLog);
    }
}
