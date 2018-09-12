package com.duteliang.spring.property;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:  获取配置文件 不指定文件他会默认获取几个配置文件: application.yml <br/>
 * ConfigFileApplicationListener 源码
 * @Auther: zl
 * @Date: 2018-8-6 16:49
 */
@Data
@ToString
@Component
public class DefaultProperties {

	/**
	 * ${} 获取数据 :后面为默认值
	 */
	@Value("${com.app-name:default}")
	private String appName;

	@Value("${com.name:default}")
	private String name;

	@Value("${duteliang.properties.test:default}")
	private String test1;




}



