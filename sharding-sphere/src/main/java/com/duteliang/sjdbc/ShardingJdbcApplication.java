package com.duteliang.sjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: zl
 * @Date: 2019-1-25 14:43
 */
@SpringBootApplication
public class ShardingJdbcApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShardingJdbcApplication.class, args);


	}

}
