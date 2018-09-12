package com.duteliang.spring.mybatis.mapper;

import com.duteliang.spring.mybatis.model.TTest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 使用注解映射
 * 使用接口注解的优点：<br/>
 * 　　1. 比较方便，快速编写映射语句 <br/>
 * 使用接口注解的缺点： <br/>
 * 　　1. 适用于比较简单的配置，当太复杂了接口就搞不定了。 <br/>
 *     2. 不能使用动态SQL，有点鸡肋。 <br/>
 * @Auther: zl
 * @Date: 2018-9-11 11:33
 */
@Mapper
@Repository
public interface TestMapper {

	/*
	 * statement="select uuid() as id":表示定义的子查询语句
	 * before=true：表示在之前执行，boolean类型的,所以为true
	 * keyColumn="id":表示查询所返回的类名
	 * resultType=String.class：表示返回值得类型
	 * keyProperty="id" ：表示将该查询的属性设置到某个列中，此处设置到id中
	 */
	@SelectKey(statement = "select uuid() as id",keyColumn = "id",before=true,resultType=String.class,keyProperty="id")
	@Insert("insert into test(id,name,date,num,sys_name) values(#{id},#{name},#{date},#{num},#{sysName})")
	int add(TTest test);

	@Insert("insert into test(id,name,date,num,sys_name) values(#{id},#{name},#{date},#{num},#{sysName})")
	int add2(TTest test);

	@Update("update test set name = #{name}, num = #{num}, date=#{date},sys_name = #{sysName} where id = #{id} ")
	int update(TTest test);

	@Delete("delete from test where id = #{id}")
	int delete(String id);

	/**
	 * id获取单个实体 自动根据驼峰规则映射
	 * @param id
	 * @return
	 */
	@Select("select * from test where id = #{id}")
	TTest getEntityByIdAuto(String id);

	/**
	 * id 获取单个实体  根据指定的规则映射
	 * 同时ResultMap可以直接指定已经有的Results
	 * @param id
	 * @return
	 */
	@Results(id = "test",value = {
		@Result(id = true,column = "id", property = "id"),
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column = "sys_name", property = "sysName"),
		@Result(column = "date", property = "date")
	})
	@Select("select * from test where id = #{id}")
	TTest getEntityByIdMapper(String id);


	@ResultMap("test")
	@Select("select * from test")
	List<TTest> queryAllEntity();
}
