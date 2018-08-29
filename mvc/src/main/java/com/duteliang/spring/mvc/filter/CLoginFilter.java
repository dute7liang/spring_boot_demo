package com.duteliang.spring.mvc.filter;

import com.duteliang.spring.mvc.constanst.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description: 拦截页面
 * @Auther: zl
 * @Date: 2018-8-29 11:26
 */
@WebFilter(filterName = "loginFilter",
		urlPatterns = "/*",
		initParams = {
			@WebInitParam(name = "exclusions-static", value = ".css,.js,.html"),
			@WebInitParam(name = "exclusions-url", value = Constants.LOGIN_URL),
		})
@Slf4j
public class CLoginFilter  implements Filter {

	private String[] exclusionsStatic;

	private String[] exclusionUrl;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String exclusionParam = filterConfig.getInitParameter("exclusions-static");
		exclusionsStatic = exclusionParam.split(",");
		exclusionParam = filterConfig.getInitParameter("exclusions-url");
		exclusionUrl = exclusionParam.split(",");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		StringBuffer requestURL = servletRequest.getRequestURL();
		// 静态资源放行
		for (String staticString : exclusionsStatic) {
			if(requestURL.toString().endsWith(staticString)){
				chain.doFilter(request, response);
				return;
			}
		}
		// 指定url放行
		for (String url : exclusionUrl) {
			if(requestURL.toString().contains(url)){
				chain.doFilter(request, response);
				return;
			}
		}

		Object attribute = session.getAttribute(Constants.SESSION_STATUS);
		if(attribute != null && "1".equals(attribute.toString())){
			chain.doFilter(request, response);
		} else {
			servletResponse.sendRedirect(Constants.LOGIN_URL);
		}
	}

	@Override
	public void destroy() {

	}
}
