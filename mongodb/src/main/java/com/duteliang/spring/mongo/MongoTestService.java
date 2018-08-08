package com.duteliang.spring.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:35
 */
@Service
public class MongoTestService {

	@Autowired
	private MongoTemplate mongoTemplate;




}
