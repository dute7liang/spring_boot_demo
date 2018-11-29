package com.duteliang.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: zl 常用方法
 * @Date: 2018-11-29 15:07
 */
@Service
public class RedisServiceImpl {

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	public void set(String key,String value){
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * @param timeOut 单位为秒
	 */
	public void setEx(String key,String value,long timeOut){
		redisTemplate.opsForValue().set(key,value , timeOut, TimeUnit.SECONDS);
	}

	public String get(String key){
		return redisTemplate.opsForValue().get(key);
	}

	public void del(String key){
		redisTemplate.delete(key);
	}

	/**
	 * @param timeOut 单位为秒
	 */
	public boolean expire(String key,long timeOut){
		return redisTemplate.boundValueOps(key).expire(timeOut, TimeUnit.SECONDS);
	}



}
