package com.duteliang.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:28
 */
@SpringBootApplication
//@EnableWebMvc
@ServletComponentScan // 开启servlet注解，监听器和过滤器
@Slf4j
public class MvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MvcApplication.class, args);
		log.info("mvc demo is start.");
	}

}
