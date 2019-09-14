package com.desheng.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desheng.mapper.LeaveInfoMapper;
import com.desheng.mapper.LeaveInfoUserMapper;
import com.desheng.pojo.*;
import com.desheng.service.activiti.ActivitiService;
import com.desheng.service.activiti.LeaveInfoService;
import com.desheng.util.shiro.ShiroUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service("leaveInfoService")
public class LeaveInfoServiceImpl implements LeaveInfoService {
    @Autowired
    private LeaveService leaveService;
    @Autowired
    private LeaveInfoMapper leaveInfoMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private LeaveInfoUserMapper leaveInfoUserMapper;
    @Autowired
    private ActivitiService activitiService;


    @Override
    public void addLeaveInfo(LeaveInfo leaveInfo) {
        //新增一个请假单
        Integer id = (int) (Math.random() * 1000);
        try {
            //拿到申请人的主键
            leaveInfo.setProposerId(ShiroUtil.copyProperties(User.class).getId().toString());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //根据流程定义的key查询部署流程id
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(leaveInfo.getProcessDefinitionKey()).singleResult();
        leaveInfo.setDeploymentId(processDefinition.getDeploymentId());
        leaveInfo.setId(id);
        leaveInfo.setSpStatus(1);
        leaveInfoMapper.insertSelective(leaveInfo);
        //启动流程
        //leaveService.startProcess(processDefinitionKey, id.toString());
        Map<String, Object> variables = new HashMap<>();
        variables.put("assign", "wulei,lisi,zhangsan");//传入认领任务角色
        //最好把业务单据ID带上不然后面不能查询是那个业务单据
        // leaveService.startProcess(processDefinitionKey,variables);
        leaveService.startProcess(leaveInfo.getProcessDefinitionKey(), id.toString(), variables);
    }


    /**
     * 相关用户登陆查询自己对应的角色如（项目经理，人事经理）是否有任务
     *
     * @param username 用户名
     * @return
     */
    @Override
    public List<LeaveInfo> queryTaskByUserAndRoleId(String username) {
        //查询代办任务
        List<Task> taskByUserId = leaveService.findTaskByUserId(username);
        List<LeaveInfo> result = new ArrayList<>();
        for (Task task : taskByUserId) {
            //取出业务单据ID
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            String businessKey = processInstance.getBusinessKey();
            LeaveInfo leaveInfo = leaveInfoMapper.selectByPrimaryKey(Integer.valueOf(businessKey));
            leaveInfo.setTaskId(task.getId());
            result.add(leaveInfo);
        }
        return result;
    }

    @Override
    public List<LeaveInfo> queryByUserId(String proposerId) {
        LeaveInfoExample leaveInfoExample = new LeaveInfoExample();
        leaveInfoExample.createCriteria().andProposerIdEqualTo(proposerId).andSpStatusEqualTo(1);
        List<LeaveInfo> leaveInfos = leaveInfoMapper.selectByExample(leaveInfoExample);
        return leaveInfos;
    }

    @Override
    public List<LeaveInfo> queryEndByUserId(String proposerId) {
        LeaveInfoExample leaveInfoExample = new LeaveInfoExample();
        leaveInfoExample.createCriteria().andProposerIdEqualTo(proposerId).andSpStatusEqualTo(2);
        List<LeaveInfo> leaveInfos = leaveInfoMapper.selectByExample(leaveInfoExample);
        return leaveInfos;
    }

    /**
     * 审批
     *
     * @param taskId   审批那个任务 主键
     * @param username 谁审批的
     * @param audit    通过（pass） 驳回（reject）
     */
    @Override
    @Transactional
    public void completeTaskByUser(String taskId, String username, String audit) throws Exception {
        //取出业务单据ID记录当前审批人的信息
        List<LeaveInfo> leaveInfos = queryTaskByUserAndRoleId(username);
        for (LeaveInfo leaveInfo : leaveInfos) {
            LeaveInfoUser leaveInfoUser = new LeaveInfoUser();
            leaveInfoUser.setSpTime(new Date());
            leaveInfoUser.setUsername(username);
            leaveInfoUser.setSpUserStatus(audit);
            leaveInfoUser.setLeaveInfoId(leaveInfo.getId());
            leaveInfoUserMapper.insertSelective(leaveInfoUser);
        }
        leaveService.completeTaskByUser(taskId, username, audit);

    }

    @Override
    public List<LeaveInfoUser> queryLeaveInfoUser(Integer leaveInfoId) {
        LeaveInfoUserExample leaveInfoUserExample = new LeaveInfoUserExample();
        leaveInfoUserExample.setOrderByClause("sp_time asc");
        leaveInfoUserExample.createCriteria().andLeaveInfoIdEqualTo(leaveInfoId);
        List<LeaveInfoUser> leaveInfoUsers = leaveInfoUserMapper.selectByExample(leaveInfoUserExample);
        return leaveInfoUsers;
    }

    @Override
    public void removeTask(String id, String deploymentId) throws Exception {

    }
}
