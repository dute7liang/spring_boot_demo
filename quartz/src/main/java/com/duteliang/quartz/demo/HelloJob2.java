package com.duteliang.quartz.demo;

import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.*;

import java.util.Date;
import java.util.Random;

/**
 * @author: zl
 * @Date: 2018-12-22 14:41
 */
@Data
/**
 * 该注解 变成不允许多线程重复执行， 相同的job名称不能同时执行。
 */
@DisallowConcurrentExecution
/**
 * 该注解job在重复执行时，如果改变JobDetail中的JobDataMap里面参数，会一直传递下去，
 * Trigger里面的map不受此注解的影响
 */
@PersistJobDataAfterExecution
public class HelloJob2 implements Job {

	private String key;

	private Integer age;

	private Double price;


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		Date date = new Date();
		String format = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
		System.out.println("hello job :" + format);
		Random random = new Random();


		JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
		String jobKey = jobDataMap.getString("key");
		System.out.println("job key = " + jobKey);

		jobDataMap.put("key", random.nextInt(10)+" job");

		JobDataMap triggerMap = jobExecutionContext.getTrigger().getJobDataMap();
		String triggerKey = triggerMap.getString("key");
		System.out.println("trigger key = " + triggerKey);

		triggerMap.put("key", random.nextInt(10)+" trigger");

		/**
		 * merge 优先获取 trigger 里面的参数
		 */
		JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
		String key1 = mergedJobDataMap.getString("key");
		System.out.println("merge map key = " + key1);

		/**
		 * getSet 自动获取参数
		 */
		System.out.println("getSet自动获取 key:"+this.key);
		System.out.println("getSet自动获取 age:"+this.age);
		System.out.println("getSet自动获取 price:"+this.price);


		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
