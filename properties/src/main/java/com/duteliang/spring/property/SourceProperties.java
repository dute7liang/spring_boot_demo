package com.duteliang.spring.property;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Description:  引入自定义配置文件
 * @Auther: zl
 * @Date: 2018-8-6 17:22
 */
@Data
@ToString
@Component
@PropertySource("classpath:config/source.properties")
public class SourceProperties {

	@Value("${com.test.bool}")
	private boolean bool;

	@Value("${com.test.string}")
	private String string;

	@Value("${com.test.doub}")
	private double doub;

	@Value("${com.test.i}")
	private int i;

	/**
	 * 注入一个随机数
	 */
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;


	private Date date;

	/**
	 * 这里引用了spEL的写法
	 */
	@Value("#{'${com.test.list}'.split(',')}")
	private List<Object> list;


	/**
	 * 直接赋值
	 */
	@Value("normal")
	private String normal;


	@Value("classpath:config/haha.txt")
	private Resource file; // 注入文件资源

	@Value("http://www.baidu.com")
	private Resource url; // 注入URL资源




}
