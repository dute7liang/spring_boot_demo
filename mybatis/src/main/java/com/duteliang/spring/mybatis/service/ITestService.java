package com.duteliang.spring.mybatis.service;

import com.duteliang.spring.mybatis.model.TTest;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-11 11:39
 */
public interface ITestService {

	int addTest(TTest test);

	int addTest2(TTest test);

	int updateTest(TTest test);

	int deleteTest(String id);

	TTest getTestAuto(String id);

	TTest getTestResult(String id);

	List<TTest> queryTest();


}
