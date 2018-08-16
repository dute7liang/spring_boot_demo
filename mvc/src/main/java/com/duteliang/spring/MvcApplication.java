package com.duteliang.spring;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:28
 */
@SpringBootApplication
//@EnableWebMvc
@Log4j
public class MvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MvcApplication.class, args);
		log.info("mvc demo is start.");
	}

}
