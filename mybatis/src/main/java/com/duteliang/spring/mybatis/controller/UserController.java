package com.duteliang.spring.mybatis.controller;

import com.duteliang.spring.mybatis.model.TUser;
import com.duteliang.spring.mybatis.service.IUserService;
import com.github.pagehelper.PageHelper;
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
 * @Date: 2018-9-11 16:42
 */
@RestController
@RequestMapping("userController")
@Api(description = "com.duteliang.spring.mybatis.mapper 使用xml动态sql 进行增删改查！")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@PostMapping(value = "add")
	@ApiOperation(value = "新增数据动态sql")
	public int add(TUser user){
		return userService.add(user);
	}

	@PostMapping(value = "edit")
	@ApiOperation(value = "编辑数据动态sql")
	public int edit(TUser user){
		return userService.update(user);
	}

	@PostMapping(value = "delete")
	@ApiOperation(value = "根据id删除数据")
	public int delete(String id){
		return userService.delete(id);
	}

	@PostMapping(value = "getUser")
	@ApiOperation(value = "根据id获取数据")
	public TUser getUser(String id){
		return userService.getById(id);
	}

	@PostMapping(value = "getAll")
	@ApiOperation(value = "查询所有数据")
	public List<TUser> getAll(){
		return userService.queryUser();
	}

	@PostMapping(value = "dataGrid")
	@ApiOperation(value = "分页查询数据")
	public List<TUser> dataGrid(PageHelper pageHelper){
		return userService.queryUserPage();
	}

}
