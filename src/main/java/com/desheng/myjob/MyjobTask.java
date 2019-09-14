package com.desheng.myjob;

import com.desheng.mapper.WzItfMapper;
import com.desheng.service.user.LoginLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyjobTask {
    private static Logger log = LoggerFactory.getLogger(MyjobTask.class);
    @Autowired
    LoginLogService mapper;
    /**
     * 无参任务
     */
    public void jobTest() {
        mapper.hashCode();
        log.info("没小时同步一下redis缓存");
    }

    /**
     * 带参数任务
     */
    public void jobTest(String... str) {
        log.info("暂时没想到业务场景");
    }
}
