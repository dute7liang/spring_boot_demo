package com.duteliang.spring.shiro.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-28 16:36
 */
@Data
@ToString
public class User implements Serializable {

	@Id
	private String id;

	private String userName;

	private String password;


}
