package com.duteliang.spring.mybatis.controller;

import com.duteliang.spring.mybatis.model.TMyBatisA;
import com.duteliang.spring.mybatis.service.IMyBatisAService;
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
 * @Date: 2018-9-25 16:02
 */
@RestController
@RequestMapping(value = "myBatisAController")
@Api(description = "通用mapper测试")
public class MyBatisAController extends BaseController{

	@Autowired
	private IMyBatisAService myBatisAService;

	@ApiOperation("新增")
	@PostMapping(value = "add")
	public TMyBatisA add(TMyBatisA myBatisA){
		myBatisAService.add(myBatisA);
		return myBatisA;
	}


	@PostMapping(value = "edit")
	@ApiOperation("编辑")
	public void edit(TMyBatisA myBatisA){
		myBatisAService.edit(myBatisA);
	}


	@PostMapping(value = "delete")
	@ApiOperation("删除")
	public void delete(String id){
		myBatisAService.deleteById(id);
	}

	@PostMapping(value = "getOneById")
	@ApiOperation("通过id获取实体")
	public TMyBatisA getOneById(String id){
		return myBatisAService.getById(id);
	}

	@PostMapping(value = "getAll")
	@ApiOperation("获取所有数据")
	public List<TMyBatisA> getAll(){
		return myBatisAService.getAll();
	}

	@PostMapping(value = "query")
	@ApiOperation("带条件的获取所有数据")
	public List<TMyBatisA> query(TMyBatisA myBatisA){
		return myBatisAService.query(myBatisA);
	}


	@PostMapping(value = "dataGrid")
	@ApiOperation("带分页，带条件的获取所有数据")
	public List<TMyBatisA> dataGrid(TMyBatisA myBatisA){
		return myBatisAService.dataGrid(myBatisA);
	}




}
