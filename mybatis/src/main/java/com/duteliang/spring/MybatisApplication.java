package com.duteliang.spring;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-4 20:07
 */
@SpringBootApplication
@Log4j
//@MapperScan("com.duteliang.spring.com.duteliang.spring.mybatis.mapper")  // 也可以直接使用@Mapper 注解 就不用扫描了
@EnableTransactionManagement
public class MybatisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MybatisApplication.class, args);
		log.info("com.duteliang.spring.mybatis.mapper demo is start.");
	}
}
