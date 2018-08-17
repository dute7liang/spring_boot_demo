package com.duteliang.spring.mvc.config;

import com.duteliang.spring.mvc.servlet.FirstServlet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

/**
 * @Description: java config方式配置servlet
 * @Auther: zl
 * @Date: 2018-8-17 17:08
 */
@SpringBootConfiguration
public class ServletConfig {

//	@Bean
	public void createServlet(){
		ServletRegistrationBean servlet = new ServletRegistrationBean();
		servlet.setServlet(new FirstServlet());
		servlet.addUrlMappings("/sevlet");
	}
}
