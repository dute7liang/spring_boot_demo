package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.conver.DateConvertEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description: 公用controller
 * @Auther: zl
 * @Date: 2018-7-6 15:56
 */
@ControllerAdvice
public class BaseController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		/*CustomDateEditor customDateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
		binder.registerCustomEditor(Date.class, customDateEditor);*/
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

	// 可以设置全局异常处理
	/*@ExceptionHandler(value = FileNotFoundException.class)
	public String error(){
		return "not found exception";
	}*/

}
