package com.duteliang.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-7 13:43
 */
@Component
public class AopTwoService {


	public String add(String str){
		System.out.println(this.getClass()+".add() 方法被执行！");
		if("throw".equals(str)){
			throw new RuntimeException();
		}
		return "this is test two";
	}

	public void delete(){
		System.out.println(this.getClass()+".delete() 方法被执行！");
	}

	public void update(){
		System.out.println(this.getClass()+".delete() 方法被执行！");
	}


}
