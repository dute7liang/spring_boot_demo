package com.duteliang.spring.mvc.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-17 11:05
 */
@WebListener
@Slf4j
@Order(value = 1)
public class BSecondContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		log.info("SecondContextListener 初始化启动");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		log.info("SecondContextListener 销毁");
	}
}
