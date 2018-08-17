package com.duteliang.spring.mvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: servlet  只有servlet3.0 才支持注解配置，
 * 				2.0的版本需要使用javaConfig或xml配置
 * @Auther: zl
 * @Date: 2018-8-17 16:58
 */
@WebServlet("/servlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("已进入servlet!");
//		super.doGet(req, resp);
	}
}
