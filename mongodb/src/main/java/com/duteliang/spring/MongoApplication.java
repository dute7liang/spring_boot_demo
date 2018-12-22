package com.duteliang.spring;

import com.duteliang.spring.service.MongodbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:28
 */
@SpringBootApplication
@Slf4j
public class MongoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MongoApplication.class, args);
		log.info("property demo is start.");

		MongodbService mongodbService = run.getBean("mongodbService", MongodbService.class);
		mongodbService.mainMongoSave();
	}

}
