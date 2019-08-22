package com.duteliang.spring.aop.one;

import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2019-7-17 09:52
 */
@Component
public class ChildOneService {

	public String add(String str) throws Exception{
		System.out.println(this.getClass()+".add() 方法被执行！");
		if("throw".equals(str)){
			throw new RuntimeException();
		}
		return "this is test";
	}
}
