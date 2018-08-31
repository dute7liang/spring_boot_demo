package com.duteliang.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-31 10:54
 */
@Controller
public class IndexController {

	private final static String PAGE = "html/user";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(){
		return PAGE;
	}
}
