package com.duteliang.spring;

import com.duteliang.spring.model.MongoPo;
import com.duteliang.spring.mongo.MongoTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-9 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class MongoApplicationTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MongoTestService mongoTestService;

	/**
	 * mongodb数据会自动保存一个id,不能重复
	 * 重复save的数据会自动覆盖更新
	 * @throws Exception
	 */

	@Test
	public void mongoServiceTest() throws Exception {
		String id = "this is a id";
		MongoPo mongoPo = new MongoPo();
		mongoPo.setBirthday(new Date());
		mongoPo.setGrade(100.2);
		mongoPo.setHeight(90);
		mongoPo.setName("测试数据，亲！！");
		mongoPo.setId(id);

		// add
//		mongoTestService.add(mongoPo);
		// update  主键为id  id不存在则新增
		/*mongoPo.setName("测试数据，编辑后的数据！");
		mongoTestService.update(mongoPo);*/
		// query
		/*Query query = new Query(Criteria.where("id").is(id));
		MongoPo one = mongoTemplate.findOne(query, MongoPo.class);
		System.out.println(one.toString());*/
		// delete
		/*mongoTestService.delete(id);*/
//		mongoTemplate.remove(mongoPo);
	}

	@Test
	public void mongoTemplate(){
//		this.addTestData();
//		this.dropTestData();
		/*Query query = new Query(Criteria.where("code").in("aaa","bbb","ccc"));
		Update update = new Update();
		update.set("name", "修改数据了！");
		update.set("code","aaa" );
		mongoTemplate.updateMulti(query, update, MongoPo.class);*/

		Query query = new Query(Criteria.where("code").in("aaa","bbb","ccc"));
		Update update = new Update();
		update.set("name", "修改数据了！");
		update.set("code","aaa" );
		mongoTemplate.findAndModify(query, update, MongoPo.class);

	}




	private void addTestData(){
		List<MongoPo> mongoPoList = new ArrayList<>();
		MongoPo mongoPo = new MongoPo();
		mongoPo.setBirthday(new Date());
		mongoPo.setGrade(100.0);
		mongoPo.setHeight(90);
		mongoPo.setName("测试数据，亲！！");
		mongoPo.setCode("aaa");
		mongoPoList.add(mongoPo);

		mongoPo = new MongoPo();
		mongoPo.setBirthday(new Date());
		mongoPo.setGrade(100.0);
		mongoPo.setHeight(80);
		mongoPo.setName("测试数据，亲！！");
		mongoPo.setCode("bbb");
		mongoPoList.add(mongoPo);

		mongoPo = new MongoPo();
		mongoPo.setBirthday(new Date());
		mongoPo.setGrade(100.0);
		mongoPo.setHeight(70);
		mongoPo.setName("测试数据，亲！！");
		mongoPo.setCode("ccc");
		mongoPoList.add(mongoPo);

		mongoPo = new MongoPo();
		mongoPo.setBirthday(new Date());
		mongoPo.setGrade(100.0);
		mongoPo.setHeight(60);
		mongoPo.setName("测试数据，亲！！");
		mongoPo.setCode("ddd");
		mongoPoList.add(mongoPo);
		mongoTemplate.insertAll(mongoPoList);
	}

	private void dropTestData(){
		mongoTemplate.dropCollection(MongoPo.class);
	}


}