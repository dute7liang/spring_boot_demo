package com.duteliang.spring.shiro;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-28 16:33
 */
@SpringBootApplication
@Log4j
@EnableTransactionManagement
public class ShiroApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ShiroApplication.class, args);
		log.info("shiro Application 项目已启动！");

	}
}
