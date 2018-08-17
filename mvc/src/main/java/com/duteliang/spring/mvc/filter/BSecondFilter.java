package com.duteliang.spring.mvc.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 第二个过滤器
 * @Auther: zl
 * @Date: 2018-8-17 15:49
 */
@WebFilter(filterName = "secondFilter")
@Slf4j
public class BSecondFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		log.info("第二个过滤器拦截到的uri:"+requestURI);
		// 执行以下代码 表示放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("第二个过滤器销毁");
	}
}
