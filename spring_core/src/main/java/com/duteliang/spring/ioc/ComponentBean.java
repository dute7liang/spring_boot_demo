package com.duteliang.spring.ioc;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description: @Component 可以直接注入spring
 * @Auther: zl
 * @Date: 2018-8-7 10:34
 */
@Component
@Data
public class ComponentBean {

	public void printer(){
		System.out.println("进入"+this.getClass()+"类的 printer 方法中！");
	}

}
