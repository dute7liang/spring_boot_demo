package com.duteliang.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: zl
 * @Date: 2018-11-29 15:26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisServiceImplTest {

	@Autowired
	private RedisServiceImpl redisService;

	@Test
	public void testRedisString() throws InterruptedException {
		String test1;

		redisService.set("test1", "test1");

		test1 = redisService.get("test1");
		log.info("test1的值为：{}",test1);

		redisService.expire(test1, 5);

		test1 = redisService.get("test1");
		log.info("test1的值为：{}",test1);

		Thread.sleep(6000);

		test1 = redisService.get("test1");
		log.info("6秒后test1的值为：{}",test1);






	}

}