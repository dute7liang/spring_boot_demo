package com.duteliang.spring;

import com.duteliang.spring.ioc.BeanService;
import com.duteliang.spring.ioc.ComponentBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-7 10:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreApplication.class)
@Slf4j
public class SpringCoreApplicationTest {

	@Autowired
	private BeanService beanService;

	@Autowired
	private ComponentBean componentBean;

	@Test
	public void beanTest(){
		beanService.printer();
	}

	@Test
	public void componentBeanTest(){
		componentBean.printer();
	}

}