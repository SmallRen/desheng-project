package com.desheng.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desheng.pojo.LeaveInfo;
import com.desheng.pojo.LeaveInfoUser;
import com.desheng.pojo.User;
import com.desheng.service.activiti.LeaveInfoService;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;
import com.desheng.util.shiro.ShiroUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("leaveInfo")
public class LeaveInfoController {
    @Autowired
    private LeaveInfoService leaveInfoService;

    @RequestMapping("/addLeaveInfo")
    public Object addLeaveInfo(LeaveInfo leaveInfo) {
        leaveInfoService.addLeaveInfo(leaveInfo);
        return ResultMsg.success("新增成功");
    }

    //根据用户对应角色查询对应的任务流程
    @RequestMapping("/queryTaskByUserAndRole")
    public Object queryTaskByUserAndRoleId(String user) {
        return leaveInfoService.queryTaskByUserAndRoleId(user);
    }

    //根据用户查询审批中对应的任务表信息leave_info
    @RequestMapping("/queryTaskByUserId")
    public Object queryTaskByUserId() {
        try {
            User user = ShiroUtil.copyProperties(User.class);
            if (user != null) {
                List<LeaveInfo> leaveInfos = leaveInfoService.queryByUserId(user.getId().toString());
                return ResultInfo.dataInfo(0, leaveInfos.size(), leaveInfos);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据用户查询审批完成对应的任务表信息leave_info
    @RequestMapping("/queryEndTaskByUserId")
    public Object queryEndTaskByUserId() {
        try {
            User user = ShiroUtil.copyProperties(User.class);
            if (user != null) {
                List<LeaveInfo> leaveInfos = leaveInfoService.queryEndByUserId(user.getId().toString());
                return ResultInfo.dataInfo(0, leaveInfos.size(), leaveInfos);
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/completeTask")
    public String completeTask(String taskId, String username, String audit) {
        try {
            leaveInfoService.completeTaskByUser(taskId, username, audit);
            return "审批完成";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "审批失败";
    }

    /**
     * leaveInfoUser
     * 查询任务审批节点信息
     */
    @RequestMapping("/leaveInfoUser")
    public Object queryLeaveInfoUser(@RequestParam("leaveInfoId") Integer leaveInfoId) {
        List<LeaveInfoUser> leaveInfoUsers = leaveInfoService.queryLeaveInfoUser(leaveInfoId);
        return ResultInfo.dataInfo(0, leaveInfoUsers.size(), leaveInfoUsers);
    }

    /**
     * 取消任务
     *
     * @param id           任务ID
     * @param deploymentId 部署流程ID
     * @return
     */
    @RequestMapping("/removeTask")
    public Object removeTask(String id, String deploymentId) {
        if (StringUtils.isBlank(deploymentId) || StringUtils.isBlank(id)) {
            ResultMsg.failure("参数为空");
        }
        try {
            leaveInfoService.removeTask(id, deploymentId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "未开发";
    }
}
