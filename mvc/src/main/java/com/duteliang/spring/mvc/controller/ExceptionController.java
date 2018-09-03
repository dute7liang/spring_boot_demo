package com.duteliang.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;

/**
 * @Description:  单个的异常处理
 * @Auther: zl
 * @Date: 2018-8-17 17:29
 */
@Controller
@RequestMapping(value = "exceptionController")
public class ExceptionController extends BaseController {


	@RequestMapping(value = "page", method = RequestMethod.GET)
	public String page() throws FileNotFoundException {
		throw new FileNotFoundException("file not found");
	}

	@ExceptionHandler(value = FileNotFoundException.class)
	public String error(){
		return "not found exception";
	}
}
