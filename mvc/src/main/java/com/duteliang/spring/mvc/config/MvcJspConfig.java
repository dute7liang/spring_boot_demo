package com.duteliang.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Description: jsp视图解析器
 * 或者可以使用boot自带的配置
 * spring:
 *  mvc:
 *   view:
 *    prefix : /WEB-INF/views/
 *    suffix : .jsp
 * @Auther: zl
 * @Date: 2018-8-16 16:59
 */
//@Configuration
//@EnableWebMvc
public class MvcJspConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/page/");
		resolver.setSuffix(".jsp");
		return resolver;
	}


	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}


}
