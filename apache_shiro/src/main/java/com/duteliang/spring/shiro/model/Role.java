package com.duteliang.spring.shiro.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 * @Auther: zl
 * @Date: 2018-9-28 16:38
 */
@Data
@ToString
public class Role implements Serializable {

	private String id;

	private String name;

}
