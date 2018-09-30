package com.duteliang.spring.shiro.controller;

import com.duteliang.spring.shiro.model.UserSubject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Description: 登陆注销 等基本登陆系统需要的接口
 * @Auther: zl
 * @Date: 2018-8-29 10:06
 */
@Controller
@RequestMapping(value = "loginController")
@Slf4j
public class LoginController extends BaseController {

	private final static String PAGE = "html/login";

	@PostMapping(value = "getCurrentUser")
	@ResponseBody
	public UserSubject getCurrentUser(HttpSession session){
		try {
			Subject subject = SecurityUtils.getSubject();
			return (UserSubject) subject.getPrincipal();
		} catch (Exception e) {
			log.info("获取当前用户失败！",e);
			return null;
		}
	}

}
