package com.duteliang.spring.mvc.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description: 第一个监听器
 * 测试结果发现 @order 注解对监听器的顺序貌似没什么影响
 * 类名对现有顺序有影响，所以暂时第一个字母来设置监听器的顺序（26个字母够用了）
 * @Auther: zl
 * @Date: 2018-8-17 11:00
 */
@WebListener
@Slf4j
@Order(value = 2)
public class AFirstContextListener implements ServletContextListener {
	/**
	 * 也就是项目启动的时候
	 * @param servletContextEvent
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.info("firstContextListener 初始化成功！");
	}

	/**
	 * 也就是项目关闭的时候
	 * @param servletContextEvent
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		log.info("firstContextListener 销毁！");
	}
}
