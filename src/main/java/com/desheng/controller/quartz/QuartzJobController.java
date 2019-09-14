package com.desheng.controller.quartz;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.desheng.exception.TaskException;
import com.desheng.pojo.SysJob;
import com.desheng.service.impl.QuartzJobServiceImpl;
import com.desheng.util.ClassScanUtils;
import com.desheng.util.MethodReflect;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("quartzJob")
public class QuartzJobController {
    private static Logger log = LoggerFactory.getLogger(QuartzJobController.class);

    @Autowired
    private QuartzJobServiceImpl quartzJobService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public Object queryJob() {
        List<SysJob> sysJobs = quartzJobService.querySysJobAll();
        ResultInfo dataInfo = ResultInfo.dataInfo(0, sysJobs.size(), sysJobs);
        return dataInfo;
    }

    /**
     * 任务调度立即执行一次
     */
    @RequestMapping(value = ("/run"), method = RequestMethod.POST)
    @ResponseBody
    public Object run(SysJob job) throws SchedulerException {
        System.out.println(job);
        quartzJobService.run(job);
        return ResultMsg.success("操作成功");
    }


    @RequestMapping(value = "/saveJob", method = RequestMethod.POST)
    @ResponseBody
    public Object addSaveJob(SysJob sysJob, @RequestParam("clsaaName") String clsaaName) throws TaskException, SchedulerException {
        sysJob.setInvokeTarget(clsaaName + "." + sysJob.getInvokeTarget());
        int i = quartzJobService.insertJob(sysJob);
        log.info(sysJob.toString());
        return ResultMsg.success("保存任务操作成功");

    }

    @RequestMapping(value = "/delJob", method = RequestMethod.POST)
    @ResponseBody
    public Object delJob(@RequestBody SysJob[] sysJob) throws SchedulerException {
        System.out.println(sysJob);
        int i = quartzJobService.deleteJobByIds(sysJob);
        if (i > 0) {
            return ResultMsg.success("删除成功");
        }
        return ResultMsg.failure("删除失败");
    }

    /**
     * 运行任务
     *
     * @param jobId 主键
     * @return
     */
    @RequestMapping(value = "/resumeJob", method = RequestMethod.POST)
    @ResponseBody
    public Object resumeJob(Long jobId) throws SchedulerException {
        int i = quartzJobService.resumeJob(jobId);
        return ResultMsg.success("任务运行成功");
    }

    /**
     * 暂停任务
     *
     * @param jobId 主键
     * @return
     */
    @RequestMapping(value = "/pauseJob", method = RequestMethod.POST)
    @ResponseBody
    public Object pauseJob(Long jobId) throws SchedulerException {
        quartzJobService.pauseJob(jobId);
        return ResultMsg.success("任务暂停成功");
    }

    /**
     * 查询类
     *
     * @return 类名.方法名(参数类型)
     */
    @RequestMapping("/queryClass")
    @ResponseBody
    public Object queryClass() {
        //目前之扫描service层
        List<?> queryInterface = ClassScanUtils.queryInterface("com.desheng.myjob");
        List<String> className = new ArrayList<>();//装类名容器
        for (Object calssPath : queryInterface) {
            try {
                String name = Class.forName(calssPath.toString()).getSimpleName();
                //首字母变成小写， 判断首字母是否为小写
                if (!Character.isLowerCase(name.charAt(0))) {
                    /**
                     * 这里涉及到ascii码表
                     * 我们知道  ascii 码表中 a的ASCIII码值是65而A的ASCII码值是  97 两个之间的差值是 32，
                     * 所以，如果我们需要把一个小写字母转化成大写字母，那么我们只需要把这个 char 字符的ascii码值加上 32
                     */
                    char[] chars = name.toCharArray();
                    chars[0] += 32;
                    name = String.valueOf(chars);//首字母变成小写，才能通过beanName从容器中获取实例
                    className.add(name);

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return ResultMsg.successData(className, "获取类名.方法(*)成功");
    }

    /**
     * 查询方法
     *
     * @return 类名.方法名(参数类型)
     */
    @RequestMapping("/queryMethod")
    @ResponseBody
    public Object queryMethod(String className) {
        List<?> objects = MethodReflect.MethodReflect(className);
        if (objects.size() > 0) {
            return ResultMsg.successData(objects, "获取类名.方法(*)成功");
        }
        return ResultMsg.failure("获取类名.方法(*)失败");

    }
}
