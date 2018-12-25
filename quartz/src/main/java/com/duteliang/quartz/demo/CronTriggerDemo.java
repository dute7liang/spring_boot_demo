package com.duteliang.quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author: zl
 * @Date: 2018-12-22 15:06
 */
public class CronTriggerDemo {

	public static void main(String[] args) {
		try {
			start("HelloWorld",null);
			start("HelloWorld2",null);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}


	public static void start(String key,String group) throws SchedulerException {
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		scheduler.start();

		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity(key, "group1")
				.build();
		jobDetail.getJobDataMap().put("key", "job");
		jobDetail.getJobDataMap().put("age", 10);
		jobDetail.getJobDataMap().put("price", 10D);


		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity(key, "group1")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
				.build();
		trigger.getJobDataMap().put("key", "trigger");
		trigger.getJobDataMap().put("age", 20);
		trigger.getJobDataMap().put("price", 20D);

		scheduler.scheduleJob(jobDetail, trigger);
	}

}
