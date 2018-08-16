package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.conver.DateConvertEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-7-6 15:56
 */
@Controller
@RequestMapping("/baseController")
public class BaseController {

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		/*CustomDateEditor customDateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
		binder.registerCustomEditor(Date.class, customDateEditor);*/

		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
