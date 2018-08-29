package com.duteliang.spring.mvc.controller;

import com.duteliang.spring.mvc.constanst.Constants;
import com.duteliang.spring.mvc.vo.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-29 10:06
 */
@Controller
@RequestMapping(value = "loginController")
public class LoginController extends BaseController {

	private final static String PAGE = "html/login";

	@RequestMapping(value = "loginPage")
	public String loginPage(){
		return PAGE;
	}

	@PostMapping(value = "login")
	@ResponseBody
	public Json login(String userName, String password, HttpServletRequest request){
		Json json = new Json();
		if("duteliang".equals(userName) && "duteliang".equals(password)){
			json.setSuccess(true);
			HttpSession session = request.getSession();
			session.setAttribute(Constants.SESSION_STATUS, "1");
			return json;
		}
		json.setSuccess(false);
		return json;
	}

	@PostMapping(value = "loginOut")
	@ResponseBody
	public Json loginOut(HttpSession session, String userName){
		Json json = new Json();
		json.setSuccess(true);
		session.invalidate();
		return json;
	}
}
