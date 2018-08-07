package com.duteliang.spring.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-7 10:23
 */
@Slf4j
@SpringBootConfiguration
public class BeanTest {


	/**
	 * @bean 可以把对象加入spring
	 * @return
	 */
	@Bean
	public BeanService addBeanService(){
		BeanService beanService = new BeanService();
		beanService.setName("张良");
		return beanService;
	}


}
