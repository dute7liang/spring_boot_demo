package com.duteliang.spring.mybatis.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-14 17:11
 */
@Data
@ToString
public class TUser implements Serializable {

	private String id;
	private String name;
	private String password;
	private Integer age;
	private Date birthday;
}
