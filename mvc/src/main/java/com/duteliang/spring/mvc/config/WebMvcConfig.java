package com.duteliang.spring.mvc.config;

import com.duteliang.spring.mvc.interceptor.FirstInterceptor;
import com.duteliang.spring.mvc.interceptor.SecondInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-17 16:47
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/**");
	}
}
