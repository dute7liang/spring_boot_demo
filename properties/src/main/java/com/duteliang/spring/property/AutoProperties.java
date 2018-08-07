package com.duteliang.spring.property;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 自动赋值
 * @Auther: zl
 * @Date: 2018-8-6 17:52
 */
@Data
@ToString
@Component
@PropertySource({"classpath:config/source.properties"})
@ConfigurationProperties(prefix = "com.test")
public class AutoProperties {

	private boolean bool;

	private String string;

	private double doub;

	private int i;

	private List<Object> list;

	/**
	 * app-name 会被解析成驼峰规则
	 */
	private String appName;
}
