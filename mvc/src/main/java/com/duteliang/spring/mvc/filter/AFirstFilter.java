package com.duteliang.spring.mvc.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 第一个拦截器
 *  测试发现，拦截器的加载顺序也是 类名来排序的
 * @Auther: zl
 * @Date: 2018-8-17 11:30
 */
@WebFilter(filterName = "firstFilter",
	urlPatterns = "/*",
	initParams = {@WebInitParam(name = "exclusions", value = "/css/*,/js/*")})
@Slf4j
public class AFirstFilter implements Filter {

	private String exclusions;


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		exclusions = filterConfig.getInitParameter("exclusions");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		log.info("第一个过滤器拦截到的uri:"+requestURI);
		// 执行以下代码 表示放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("第一个过滤器销毁");
	}
}
