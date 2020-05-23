package com.ecloud.quartz.task.test;

import com.ecloud.dao.UserDao;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dell on 2020/5/20.
 */
@Component
public class TestJob extends QuartzJobBean {
    @Autowired(required = false)
    private UserDao userDao;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date() + " ==================>" + " job执行开始");

        int result = userDao.queryCount();
        if(result > 0) {
            System.out.println(new Date() + " ==================>" + " job执行结束,查询成功");
        }else{
            System.out.println(new Date() + " ==================>" + " job执行结束,查询失败");
        }
    }
}
