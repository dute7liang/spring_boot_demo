package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.constanst.Constants;
import com.duteliang.spring.mvc.model.TUser;
import com.duteliang.spring.mvc.service.IUserService;
import com.duteliang.spring.mvc.vo.Json;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 登陆注销 等基本登陆系统需要的接口
 * @Auther: zl
 * @Date: 2018-8-29 10:06
 */
@Controller
@RequestMapping(value = "loginController")
@Slf4j
@Api
public class LoginController extends BaseController {

	private final static String PAGE = "html/login";

	@Autowired
	private IUserService userService;

	@GetMapping(value = "loginPage")
	public String loginPage(){
		return PAGE;
	}

	@PostMapping(value = "login")
	@ResponseBody
	@ApiOperation("login")
	public Json login(String userName, String password, HttpServletRequest request){
		Json json = new Json();
		try {
			TUser user = userService.getUser(password, userName);
			if(user == null){
				json.setSuccess(false);
			}else{
				json.setSuccess(true);
				HttpSession session = request.getSession();
				session.setAttribute(Constants.SESSION_STATUS, "1");
				session.setAttribute(Constants.SESSION_USER_ID, user.getId());
			}
		} catch (Exception e) {
			log.info("验证失败！",e);
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	@PostMapping(value = "getCurrentUser")
	@ResponseBody
	public TUser getCurrentUser(HttpSession session){
		Object sessionAttribute = session.getAttribute(Constants.SESSION_USER_ID);
		if(sessionAttribute == null){
			return null;
		}
		try {
			return userService.dataDetail(sessionAttribute.toString());
		} catch (Exception e) {
			log.info("获取当前用户失败！",e);
			return null;
		}
	}

	@PostMapping(value = "loginOut")
	@ResponseBody
	public Json loginOut(HttpSession session){
		Json json = new Json();
		json.setSuccess(true);
		session.invalidate();
		return json;
	}
}
