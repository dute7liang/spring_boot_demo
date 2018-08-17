package com.duteliang.spring.mvc.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-17 16:55
 */
@Slf4j
public class SecondInterceptor implements HandlerInterceptor {

	/**
	 * 在controller层之前被调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		log.info(" 第二个拦截器   preHandle被调用!");
		return true; //如果false，停止流程，api被拦截
	}

	/**
	 * 在controller层之后
	 * 在视图解析器之前
	 * 被调用
	 */
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
		log.info(" 第二个拦截器   postHandle被调用!");
	}

	/**
	 * 在视图解析器之后被调用
	 * 可以用于资源清理工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
		log.info(" 第二个拦截器   afterCompletion被调用!");
	}
}
