package com.duteliang.spring.property;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2018-12-25 10:11
 */
@Data
@ToString
@ConfigurationProperties(prefix = "com.yml.test")
@Component
public class AutoYml {

	private boolean boo;

	private String string;

	private Double aDouble;
	private Integer integer;

	private Date date;

	private List<Object> list1;

	private List<Object> list2;

	private Map<String,Object> map;



}
