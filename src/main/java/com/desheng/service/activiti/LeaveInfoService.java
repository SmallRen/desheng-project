package com.desheng.service.activiti;

import java.util.List;

import com.desheng.pojo.LeaveInfo;
import com.desheng.pojo.LeaveInfoUser;

public interface LeaveInfoService {

    //状态是有流程引擎修改

    /**
     * 新增一个请假单
     *
     * @param leaveInfo 申请信息
     */
    void addLeaveInfo(LeaveInfo leaveInfo);

    /**
     * 查询代办
     * 相关用户登陆查询自己对应的角色如（项目经理，人事经理）是否有任务
     *
     * @param userId 用户主键
     * @return
     */
    List<LeaveInfo> queryTaskByUserAndRoleId(String userId);

    /**
     * 查询用户还在审批中的任务信息
     *
     * @param proposerId 申请人ID
     * @return
     */
    List<LeaveInfo> queryByUserId(String proposerId);

    /**
     * 查询用户还在审批完成的任务信息
     *
     * @param proposerId
     * @return
     */
    List<LeaveInfo> queryEndByUserId(String proposerId);

    //完成任务
    void completeTaskByUser(String taskId, String userId, String audit) throws Exception;

    /**
     * 查询任务审批信息
     *
     * @param leaveInfoId 任务表id
     */
    List<LeaveInfoUser> queryLeaveInfoUser(Integer leaveInfoId);

    /**
     * 取消任务
     *
     * @param id           任务ID
     * @param deploymentId 部署流程ID
     * @throws Exception
     */
    void removeTask(String id, String deploymentId) throws Exception;
}
