package com.duteliang.spring.service;

import com.duteliang.spring.model.MongoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author: zl
 * @Date: 2018-12-21 17:23
 */
@Service
public class MongodbService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(MongoPo mongoPo){
		mongoTemplate.save(mongoPo);
	}

	public void mainMongoSave(){
		MongoPo mongoPo;
		for (int i = 0; i < 100000; i++) {
			mongoPo = new MongoPo();
			mongoPo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			mongoPo.setCode("code"+i);
			mongoPo.setName("name"+i);
			mongoPo.setHeight(i);
			mongoPo.setGrade(Double.parseDouble(i+""));
			mongoPo.setBirthday(new Date());
			mongoTemplate.save(mongoPo);
		}
	}

	public static void main(String[] args) {
		String s = UUID.randomUUID().toString().replaceAll("-", "");
		System.out.println(s);
	}

}
