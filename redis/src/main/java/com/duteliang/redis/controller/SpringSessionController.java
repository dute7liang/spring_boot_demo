package com.duteliang.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: zl
 * @Date: 2018-11-29 19:46
 */
@Controller
@RequestMapping(value = "")
@Slf4j
public class SpringSessionController {

	@RequestMapping(value = "setSession")
	@ResponseBody
	public void setSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("22222", "2222");
		log.info("sessionId = {}",session.getId());

	}

	@RequestMapping(value = "getSession")
	@ResponseBody
	public Object getSession(HttpSession session){
		return session.getAttribute("22222");
	}


}
