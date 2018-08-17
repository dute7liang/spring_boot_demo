package com.duteliang.spring.mvc.config;

import com.duteliang.spring.mvc.filter.AFirstFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: javaConfig 形式配置 filter
 * @Auther: zl
 * @Date: 2018-8-17 16:37
 */
@Configuration
public class FilterConfig {

//	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		AFirstFilter testFilter = new AFirstFilter();
		List<String> urlPatterns = new ArrayList<>();
		urlPatterns.add("/*");
		filterRegistrationBean.setFilter(testFilter);
		filterRegistrationBean.setUrlPatterns(urlPatterns);
		return filterRegistrationBean;
	}
}
