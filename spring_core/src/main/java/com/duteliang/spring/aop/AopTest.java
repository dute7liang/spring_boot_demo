package com.duteliang.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-7 10:54
 */
@Component
@Aspect
public class AopTest {

	/**
	 * execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
	 */
	/**
	 * 拆解说明：
	 *  public 表示 修饰符public，可省略
	 *  *  任何返回类型
	 *  com.duteliang.spring.aop  表示指定包名,会扫描该包名下的类和所有子类
	 *  ..  用于分割 包名和类名
	 *  *Service   表示以Service结尾的class
	 *  .*Add(..)  表示以Add结尾的方法名,括号里面表示任何入参
	 */
	@Pointcut("execution(public * com.*.*.aop..*OneService.*add(..))")
	public void doService(){}

	/*@Before("doService()")
	public void before(JoinPoint jp){
		System.out.println("before 前置事件！");
	}

	// 不管是抛出异常或者正常退出都会执行
	@After("doService()")
	public void after(JoinPoint jp){
		System.out.println("after 后置事件！");
	}

	// 方法退出时执行
	@AfterReturning(returning = "obj", pointcut = "doService()")
	public void afterReturning(Object obj) throws Throwable {
		System.out.println("方法的返回值 : " + obj);
	}


	@AfterThrowing(throwing = "ex", pointcut = "doService()")
	public void afterThrowing(JoinPoint jp,Exception ex){
		System.out.println("方法异常时执行.....");
	}*/

	//环绕通知,环绕增强，相当于MethodInterceptor
	//灵活性最强
	@Around("doService()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("方法环绕start.....");
		try {
			Object proceed = pjp.proceed();
		}catch (Exception e){
			System.out.println("方法报错了");
		}
		return null;
	}






}
