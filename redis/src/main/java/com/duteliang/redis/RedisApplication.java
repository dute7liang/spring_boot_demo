package com.duteliang.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: zl
 * @Date: 2018-11-29 15:02
 */
@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(RedisApplication.class, args);

	}

}
