package com.ecloud.quartz.task.service;

import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2020/5/20.
 */
public interface TaskService {

    //增加一个job
    public void addJob(Class<? extends QuartzJobBean> jobClass, String jobName, String jobGroupName, int jobTime, int jobTimes);

    //增加一个job
    public void addJob(Class<? extends QuartzJobBean> jobClass, String jobName, String jobGroupName, String jobTime);

    //修改job
    public void updateJob(String jobName, String jobGroupName, String jobTime);

    //删除job
    public void deleteJob(String jobName, String jobGroupName);

    //暂停job
    public void pauseJob(String jobName, String jobGroupName);

    //恢复job
    public void resumeJob(String jobName, String jobGroupName);

    //立即执行job
    public void runAJobNow(String jobName, String jobGroupName);

    //查询所有job
    public List<Map<String, Object>> queryAllJob();

    //查询所有正在运行的job
    public List<Map<String, Object>> queryRunJob();



}
