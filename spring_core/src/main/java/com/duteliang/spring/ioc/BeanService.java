package com.duteliang.spring.ioc;

import lombok.Data;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-7 10:24
 */

@Data
public class BeanService {

	private String name;

	public void printer(){
		System.out.println("name="+name);
		System.out.println("进入"+this.getClass()+"printer 方法！");
	}
}
