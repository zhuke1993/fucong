package com.zhuke.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;

/**
 * Created by ZHUKE on 2015/10/26.
 */
public class MyJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务正在执行，执行时间:" + Calendar.getInstance().getTime());
    }
}
