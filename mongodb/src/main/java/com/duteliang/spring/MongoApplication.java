package com.duteliang.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:28
 */
@SpringBootApplication
@Slf4j
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
		log.info("property demo is start.");
	}

}
