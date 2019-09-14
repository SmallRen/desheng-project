package com.desheng.service.impl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desheng.mapper.LeaveInfoMapper;
import com.desheng.mapper.UserMapper;
import com.desheng.pojo.LeaveInfo;
import com.desheng.pojo.User;

import java.util.*;

@Service("leaveService")
public class LeaveService {


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private LeaveInfoMapper leaveInfoMapper;

    @Autowired
    private UserMapper userMapper;

    private static Logger log = LoggerFactory.getLogger(LeaveService.class);

    /**
     * 启动流程
     *
     * @param processDefinitionKey 流程定义唯一标识
     * @param bizKey               业务单据 ID 就是请假单ID  传过来
     */
    public void startProcess(String processDefinitionKey, String bizKey) {
        //LeaveProcess 对应流程图的唯一标识
        runtimeService.startProcessInstanceByKey(processDefinitionKey, bizKey);
    }

    /**
     * @param processDefinitionKey 流程定义唯一标识
     * @param variables            全局变量参数
     */
    public void startProcess(String processDefinitionKey, Map<String, Object> variables) {
        //LeaveProcess 对应流程图的唯一标识
        runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
    }

    /**
     * @param processDefinitionKey 流程定义唯一标识
     * @param bizKey               业务单据 ID 就是请假单ID  传过来
     * @param variables            全局变量参数
     */
    public void startProcess(String processDefinitionKey, String bizKey, Map<String, Object> variables) {
        //LeaveProcess 对应流程图的唯一标识
        runtimeService.startProcessInstanceByKey(processDefinitionKey, bizKey, variables);
    }


    //查询相关审批人
    @Autowired
    private TaskService taskService;

    public List<Task> findTaskByUserId(String userId) {
        List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned(userId).list();
        return list;
    }

    /**
     * 网管审批
     *
     * @param taskId 审批那个任务
     * @param userId 谁审批的
     * @param audit  通过（pass） 驳回（reject）
     */
    public void completeTaskByUser(String taskId, String userId, String audit) {
        //认领任务
        taskService.claim(taskId, userId);
        Map<String, Object> map = new HashMap<>();
        map.put("audit", audit);
        //完成
        taskService.complete(taskId, map);

    }


    /**
     * ${leaveService.findPorjectManger(execution)}
     * 查询相关项目经理角色的人，返回相关人员的ID
     * <p>
     * 注意：必须与流程图里面方法名一模一样
     * <p>
     * DelegateExecution execution 执行示例的代理对象 （代表发起请求的具体示例，比如多个申请人）
     */
    public List<String> findPorjectManger(DelegateExecution execution) {
        List<User> porjectManger = userMapper.findPorjectManger();
        List<String> list = new ArrayList<>();
        if (porjectManger != null && porjectManger.size() > 0) {
            for (User user : porjectManger) {
                list.add(user.getUsername());
            }
        }
        log.info("findPorjectManger方法经理人员" + list);
        return list;//Arrays.asList("project1", "project2");
    }

    public List<String> findAdminManger(DelegateExecution execution) {
        List<User> porjectManger = userMapper.findPorjectManger();
        List<String> list = new ArrayList<>();
        if (porjectManger != null && porjectManger.size() > 0) {
            for (User user : porjectManger) {
                list.add(user.getUsername());
            }
        }

        return list;//Arrays.asList("admin1", "admin2");
    }

    /**
     * 查询相关人事经理
     */

    public List<String> findHrManger(DelegateExecution execution) {
        return Arrays.asList("hr1", "hr2");
    }

    /**
     * 流程图里面定义  对应服务的表达式  方法名一样 流程引擎自动执行
     * 修改业务单据状态
     */

    public void changeStatus(DelegateExecution execution, String status) {
        log.info("修改业务状态" + status);

        //取出业务单据ID
        String processBusinessKey = execution.getProcessBusinessKey();
        LeaveInfo leaveInfo = leaveInfoMapper.selectByPrimaryKey(Integer.valueOf(processBusinessKey));
        if (status == "reject") {
            leaveInfo.setSpStatus(2);//当改任务被驳回是标识 单据结束
        }
        leaveInfo.setStatus(status);
        leaveInfo.setUpdateTime(new Date());
        leaveInfoMapper.updateByPrimaryKey(leaveInfo);
    }

    /**
     * 流程图里面定义  对应服务的表达式  方法名一样 流程引擎自动执行
     * 修改业务单据状态
     * 这个方法是流程定义最后一个服务 ，也代流程走完，所以标识该任务流程走完
     */

    public void changeStatus(DelegateExecution execution, String status, String spStatus) {
        log.info("修改业务状态" + status + spStatus);

        //取出业务单据ID
        String processBusinessKey = execution.getProcessBusinessKey();
        LeaveInfo leaveInfo = leaveInfoMapper.selectByPrimaryKey(Integer.valueOf(processBusinessKey));
        if ("end".equalsIgnoreCase(spStatus)) {
            leaveInfo.setSpStatus(2);//当改任务被驳回是标识 单据结束
        }
        leaveInfo.setStatus(status);
        leaveInfo.setUpdateTime(new Date());
        leaveInfoMapper.updateByPrimaryKey(leaveInfo);
    }
}
