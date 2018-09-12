package com.duteliang.spring.mybatis.controller;

import com.duteliang.spring.mybatis.model.TTest;
import com.duteliang.spring.mybatis.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-11 11:57
 */
@RestController
@RequestMapping("testController")
@Api(description = "com.duteliang.spring.mybatis.mapper 通过注解来实现 增删改查")
public class TestController extends BaseController {

	@Autowired
	private ITestService testService;

	@PostMapping("add")
	// 方法的说明
	@ApiOperation(value = "新增数据,id为自动生成的uuid",response = String.class)
	public int add(TTest test){
		return testService.addTest(test);
	}

	@PostMapping("add2")
	@ApiOperation(value = "新增数据，id为手动给的字符串")
	public int add2(TTest test){
		return testService.addTest2(test);
	}


	@PostMapping("update")
	@ApiOperation(value = "根据id 更新单挑数据, 没有动态sql")
	public int update(TTest test){
		return testService.updateTest(test);
	}

	@PostMapping("delete")
	@ApiOperation(value = "根据id 删除数据")
	public int delete(String id){
		return testService.deleteTest(id);
	}


	@PostMapping("getEntityByIdAuto")
	@ApiOperation(value = "根据id 获取单个实体，自动根据驼峰规则赋值")
	public TTest getEntityByIdAuto(String id){
		return testService.getTestAuto(id);
	}

	@PostMapping("getEntityByIdMapper")
	@ApiOperation(value = "根据id获取单个实体，更具手动指定的result来赋值")
	public TTest getEntityByIdMapper(String id){
		return testService.getTestResult(id);
	}

	@PostMapping("getAllEntity")
	@ApiOperation(value = "获取所有数据")
	public List<TTest> getAllEntity(){
		return testService.queryTest();
	}

}
