package com.desheng.service.impl;

import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.desheng.exception.TaskException;
import com.desheng.mapper.SysJobMapper;
import com.desheng.pojo.SysJob;
import com.desheng.pojo.SysJobExample;
import com.desheng.service.quartz.QuartzJobService;
import com.desheng.util.quartz.ScheduleConstants;
import com.desheng.util.quartz.ScheduleUtils;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("quartzJobService")

public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private SysJobMapper sysJobMapper;
    @Autowired
    private Scheduler scheduler;


    /**
     * 项目启动时，初始化定时器
     * 主要是防止手动修改数据库导致未同步到定时任务处理（注：不能手动修改数据库ID和任务组名，否则会导致脏数据）
     */
    //@PostConstruct
    public void init() throws SchedulerException, TaskException {
        List<SysJob> jobList = sysJobMapper.selectByExample(null);
        for (SysJob job : jobList) {
            updateSchedulerJob(job, job.getJobGroup());
        }
    }

    /**
     * 更新任务
     *
     * @param job      任务对象
     * @param jobGroup 任务组名
     */
    public void updateSchedulerJob(SysJob job, String jobGroup) throws SchedulerException, TaskException {
        Long jobId = job.getJobId();
        // 判断是否存在
        JobKey jobKey = ScheduleUtils.getJobKey(jobId, jobGroup);
        if (scheduler.checkExists(jobKey)) {
            // 防止创建时存在数据问题 先移除，然后在执行创建操作
            scheduler.deleteJob(jobKey);
        }
        ScheduleUtils.createScheduleJob(scheduler, job);
    }

    @Override
    public List<SysJob> querySysJobAll() {
        List<SysJob> sysJobs = sysJobMapper.selectByExample(null);
        return sysJobs;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int insertJob(SysJob sysJob) throws TaskException, SchedulerException {
        sysJob.setStatus(ScheduleConstants.Status.PAUSE.getValue());
        int i = sysJobMapper.insertSelective(sysJob);
        //保存成功创建任务调度
        if (i > 0) {
            ScheduleUtils.createScheduleJob(scheduler, sysJob);
        }
        return i;
    }

    /**
     * 执行一次
     *
     * @param job 调度信息
     * @throws SchedulerException
     */
    @Override
    public void run(SysJob job) throws SchedulerException {
        Long jobId = job.getJobId();
        SysJob properties = selectJobById(job.getJobId());
        String jobGroup = properties.getJobGroup();
        // 参数
        JobDataMap dataMap = new JobDataMap();
        dataMap.put(ScheduleConstants.TASK_PROPERTIES, properties);
        scheduler.triggerJob(ScheduleUtils.getJobKey(jobId, jobGroup), dataMap);
    }

    /**
     * 批量删除调度信息
     * 删除任务后，所对应的trigger也将被删除
     *
     * @param sysJob 调度信息
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public int deleteJobByIds(SysJob[] sysJob) throws SchedulerException {
        if (sysJob.length <= 0) {
            return 0;
        } else {
            SysJobExample example = new SysJobExample();
            for (SysJob job : sysJob) {
                Long jobId = job.getJobId();
                String jobGroup = job.getJobGroup();
                example.createCriteria().andJobIdEqualTo(jobId);
                int rows = sysJobMapper.deleteByExample(example);
                if (rows > 0) {
                    scheduler.deleteJob(ScheduleUtils.getJobKey(jobId, jobGroup));
                }
            }
            return 1;
        }
    }

    /**
     * 暂停任务
     *
     * @param jobId 主键
     */
    @Override
    @Transactional
    public int pauseJob(Long jobId) throws SchedulerException {
        SysJob job = selectJobById(jobId);
        String jobGroup = job.getJobGroup();
        //更新sysjob表里面的status状态为0
        job.setStatus(ScheduleConstants.Status.PAUSE.getValue());
        int rows = sysJobMapper.updateByPrimaryKeySelective(job);
        if (rows > 0) {
            scheduler.pauseJob(ScheduleUtils.getJobKey(jobId, jobGroup));
        }
        return rows;
    }

    /**
     * 恢复任务
     *
     * @param jobId 调度信息
     */
    @Override
    @Transactional
    public int resumeJob(Long jobId) throws SchedulerException {
        SysJob job = selectJobById(jobId);
        String jobGroup = job.getJobGroup();
        //更新sysjob表里面的status状态为1
        job.setStatus(ScheduleConstants.Status.NORMAL.getValue());
        int rows = sysJobMapper.updateByPrimaryKeySelective(job);
        if (rows > 0) {
            scheduler.resumeJob(ScheduleUtils.getJobKey(jobId, jobGroup));
        }
        return rows;
    }

    /**
     * 通过调度任务ID查询调度信息
     *
     * @param jobId 调度任务ID
     * @return 调度任务对象信息
     */
    @Override
    public SysJob selectJobById(Long jobId) {
        SysJobExample example = new SysJobExample();
        example.createCriteria().andJobIdEqualTo(jobId);
        return sysJobMapper.selectByExample(example).get(0);
    }

}
