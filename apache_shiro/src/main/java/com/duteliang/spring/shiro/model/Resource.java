package com.duteliang.spring.shiro.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-28 16:39
 */
@Data
@ToString
public class Resource implements Serializable {

	private String id;

	private String name;

	private String url;

}
