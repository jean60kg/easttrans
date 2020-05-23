package com.ecloud.quartz.task.controller;

/**
 * Created by dell on 2020/5/20.
 */
import com.ecloud.quartz.task.test.TestJob;
import com.ecloud.quartz.task.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/client/task")
public class TaskController {

    @Autowired
    private TaskServiceImpl quartzService;

    @RequestMapping("/addjob")
    public void startJob() {
         quartzService.addJob(TestJob.class, "test-job", "test", "0/5 * * * * ?");
    }

    @RequestMapping("/updatejob")
    public void updatejob() {
        quartzService.updateJob("test-job", "test", "0/10 * * * * ?");
    }

    @RequestMapping("/deletejob")
    public void deletejob() {
        quartzService.deleteJob("test-job", "test");
    }

    @RequestMapping("/pauseJob")
    public void pauseJob() {
        quartzService.pauseJob("test-job", "test");
    }

    @RequestMapping("/resumeJob")
    public void resumeJob() {
        quartzService.resumeJob("test-job", "test");
    }

    @RequestMapping("/queryAllJob")
    public Object queryAllJob() {
        return quartzService.queryAllJob();
    }

    @RequestMapping("/queryRunJob")
    public Object queryRunJob() {
        return quartzService.queryRunJob();
    }
}
