package com.duteliang.spring.mybatis.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description: 注解形式使用mybatis
 * @Auther: zl
 * @Date: 2018-9-11 11:29
 */
@Data
@ToString
public class TTest {

	private String id;
	private String name;
	private Date date;
	private Double num;
	private String sysName;
}
