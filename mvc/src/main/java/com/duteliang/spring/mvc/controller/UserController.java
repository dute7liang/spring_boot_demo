package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.constanst.MsgEnum;
import com.duteliang.spring.mvc.model.TUser;
import com.duteliang.spring.mvc.service.IUserService;
import com.duteliang.spring.mvc.vo.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-14 17:12
 */
@Controller
@RequestMapping("userController")
@Slf4j
public class UserController extends BaseController {

	private final static String PAGE = "html/user";

	@Autowired
	private IUserService userService;

	/**
	 *
	 *
	 *
	 */
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public String page(){
		return PAGE;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public Json add(TUser user){
		try {
			userService.add(user);
			return new Json(true, MsgEnum.ADD_SUCCESS.getMsg());
		} catch (Exception e) {
			log.error(MsgEnum.ADD_FAULT.getMsg(),e);
			return new Json(MsgEnum.ADD_FAULT.getMsg());
		}
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Json update(TUser user){
		try {
			userService.update(user);
			return new Json(true,MsgEnum.UPDATE_SUCCESS.getMsg());
		} catch (Exception e) {
			log.error(MsgEnum.UPDATE_FAULT.getMsg(),e);
			return new Json(MsgEnum.UPDATE_FAULT.getMsg());
		}
	}


	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public Json delete(String id){
		try {
			userService.delete(id);
			return new Json(true,MsgEnum.DELETE_SUCCESS.getMsg());
		} catch (Exception e) {
			log.error(MsgEnum.DELETE_FAULT.getMsg(),e);
			return new Json(MsgEnum.DELETE_FAULT.getMsg());
		}
	}


	@RequestMapping(value = "dataDetail", method = RequestMethod.POST)
	@ResponseBody
	public TUser dataDetail(String id){
		try {
			return userService.dataDetail(id);
		} catch (Exception e) {
			log.error("查询失败！", e);
		}
		return null;
	}

	@RequestMapping(value = "queryUser", method = RequestMethod.POST)
	@ResponseBody
	public List<TUser> queryUser(TUser user){
		try {
			return userService.queryList(user);
		} catch (Exception e) {
			log.error("查询失败！", e);
		}
		return null;
	}

	@RequestMapping(value = "test", method = RequestMethod.POST)
	@ResponseBody
	public TUser test(TUser user){
		return user;
	}


	@PostMapping(value = "testParam1")
	@ResponseBody
	public String testParam1(@RequestParam(value = "name1") String name){
		return name;
	}

	@PostMapping(value = "testParam2/{id}")
	@ResponseBody
	public String testParam2(@PathVariable(value = "id") String id){
		return id;
	}




}
