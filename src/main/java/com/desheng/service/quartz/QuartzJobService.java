package com.desheng.service.quartz;

import org.quartz.SchedulerException;

import com.desheng.exception.TaskException;
import com.desheng.pojo.SysJob;

import java.util.List;

public interface QuartzJobService {
    /**
     * 查询全部任务工作
     *
     * @return
     */
    List<SysJob> querySysJobAll();

    /**
     * 保存新增任务工作
     *
     * @param sysJob
     * @return
     */
    int insertJob(SysJob sysJob) throws TaskException, SchedulerException;

    /**
     * 通过调度任务ID查询调度信息
     *
     * @param jobId 调度任务ID
     * @return 调度任务对象信息
     */
    SysJob selectJobById(Long jobId);

    /**
     * 立即运行任务
     *
     * @param job 调度信息
     * @return 结果
     */
    void run(SysJob job) throws SchedulerException;

    /**
     * 暂停任务
     *
     * @param jobId
     */
    int pauseJob(Long jobId) throws SchedulerException;

    /**
     * 恢复任务
     *
     * @param jobId
     */
    int resumeJob(Long jobId) throws SchedulerException;

    /**
     * 批量删除调度信息
     * 删除任务后，所对应的trigger也将被删除
     *
     * @param sysJob 调度信息
     * @return
     */
    int deleteJobByIds(SysJob[] sysJob) throws SchedulerException;
}
