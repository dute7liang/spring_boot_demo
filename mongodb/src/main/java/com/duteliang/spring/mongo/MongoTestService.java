package com.duteliang.spring.mongo;

import com.duteliang.spring.model.MongoPo;
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


	public void add(MongoPo mongoPo){
		mongoTemplate.save(mongoPo);
	}

	public void update(MongoPo mongoPo){

	}


	public void delete(String id){

	}

	public void queryAll(String document){
	}

}
