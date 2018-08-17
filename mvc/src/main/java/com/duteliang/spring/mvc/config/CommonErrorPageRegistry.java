package com.duteliang.spring.mvc.config;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Description: 错误页面的重新调整
 * @Auther: zl
 * @Date: 2018-8-17 17:21
 */
@Component
public class CommonErrorPageRegistry implements ErrorPageRegistrar {
	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage page404 = new ErrorPage(HttpStatus.NOT_FOUND,"/html/404.html");
		ErrorPage page500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/html/500.html");
		ErrorPage pageNullPoint = new ErrorPage(NullPointerException.class,"/html/500.html");
		registry.addErrorPages(page404,page500,pageNullPoint);
	}
}
