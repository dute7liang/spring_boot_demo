package com.duteliang.spring.mvc.activemq;

import com.duteliang.spring.MvcApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-3 11:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MvcApplication.class)
public class ConsumerTest {

	@Autowired
	private Consumer consumer;


	@Test
	public void consumer(){
		consumer.syso();
	}

}