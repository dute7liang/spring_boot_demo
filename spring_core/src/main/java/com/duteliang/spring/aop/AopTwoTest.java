package com.duteliang.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2018-11-27 19:38
 */
@Component
@Aspect
public class AopTwoTest {

	@Pointcut("execution(public * com.duteliang.spring.aop..*TwoService.*add(..))")
	public void doService(){}

	@Around("doService()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("方法环绕start.....");
		Object proceed = pjp.proceed();
		return proceed;
	}
}
