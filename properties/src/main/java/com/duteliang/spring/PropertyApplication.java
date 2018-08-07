package com.duteliang.spring;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-6 16:47
 */
@SpringBootApplication
@Log4j
public class PropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyApplication.class, args);
		log.info("property demo is start.");
	}
}
