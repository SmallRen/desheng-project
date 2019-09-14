package com.desheng.listeners;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 如果流程图里没有设置变量人员，可以设置监听器来分配任务
 * 注意：前提是页面没有设置候选人，
 *
 * 任务监听器里面配置对应类额全路劲 com.petroleum.listeners.MyTaskListener
 */
public class MyTaskListener implements TaskListener {
    private static Logger log = LoggerFactory.getLogger(MyTaskListener.class);

    @Override
    public void notify(DelegateTask delegateTask) {
        String assignee = delegateTask.getAssignee();
        log.info("流程" + assignee);
        //分配候选人
        delegateTask.setAssignee("lisi");
        /*if (assignee != null && assignee.length() > 0) {
            String[] split = assignee.split(",");
            for (String str : split) {
            }
        }*/
    }
}
