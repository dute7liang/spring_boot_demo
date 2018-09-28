package com.duteliang.spring.shiro.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-28 16:36
 */
@Data
@ToString
public class User implements Serializable {

	private String id;

	private String name;

	private String password;


}
