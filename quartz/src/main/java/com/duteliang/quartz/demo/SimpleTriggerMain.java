package com.duteliang.quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 *
 * @author: zl
 * @Date: 2018-12-22 14:37
 */
public class SimpleTriggerMain {

	public static void main(String[] args) {

		try {
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			// and start it off
			scheduler.start();

			// define the job and tie it to our HelloJob class
			JobDetail job = JobBuilder.newJob(HelloJob.class)
					.withIdentity("helloJob", "group1")
					.build();

			// Trigger the job to run now, and then repeat every 40 seconds
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger1", "group1")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(2)
							.repeatForever())
					.build();

			// Tell quartz to schedule the job using our trigger
			scheduler.scheduleJob(job, trigger);


			Thread.sleep(10000);

			scheduler.shutdown();

		} catch (SchedulerException | InterruptedException se) {
			se.printStackTrace();
		}


	}

}
