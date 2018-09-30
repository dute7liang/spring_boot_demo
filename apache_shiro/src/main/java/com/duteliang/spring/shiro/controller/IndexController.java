package com.duteliang.spring.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zl
 * @Date: 2018-9-29 18:04
 */
@Controller
public class IndexController extends BaseController {

	private final static String INDEX_PAGE = "html/user";

	@RequestMapping(value = "/")
	public String index(){
		return INDEX_PAGE;
	}


}
