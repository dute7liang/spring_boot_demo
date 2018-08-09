package com.duteliang.spring.mongo;

import com.duteliang.spring.model.MongoPo;
import com.duteliang.spring.util.BeanMapUtil;
import com.mongodb.BasicDBObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:35
 */
@Service
public class MongoTestService {

	@Autowired
	private MongoTemplate mongoTemplate;


	public void add(MongoPo mongoPo) throws Exception{
		if(mongoPo != null){
			mongoTemplate.save(mongoPo);
		}
	}

	public void update(MongoPo mongoPo)  throws Exception{
		Assert.notNull(mongoPo, "mongoPo 不能为null！");
		if(StringUtils.isEmpty(mongoPo.getId())){
			add(mongoPo);
		}
		Query query = new Query(Criteria.where("id").is(mongoPo.getId()));
		Map<String, Object> map = BeanMapUtil.bean2Map(mongoPo);
		BasicDBObject dbObject = new BasicDBObject(map);
		mongoTemplate.updateFirst(query, Update.fromDBObject(dbObject), MongoPo.class);
	}

	public void delete(String id) throws Exception{
		Assert.notNull(id, "if delete so id is not null!");
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.findAndRemove(query, MongoPo.class);
	}

	public <T> List<T> queryAll(Class<T> entityClass){
		return mongoTemplate.findAll(entityClass);
	}

}
