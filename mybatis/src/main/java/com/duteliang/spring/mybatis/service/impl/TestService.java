package com.duteliang.spring.mybatis.service.impl;

import com.duteliang.spring.mybatis.mapper.TestMapper;
import com.duteliang.spring.mybatis.model.TTest;
import com.duteliang.spring.mybatis.service.ITestService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-11 11:42
 */
@Service
@Transactional
@Log4j
public class TestService implements ITestService {

	@Autowired
	private TestMapper testMapper;

	@Override
	public int addTest(TTest test) {
		int i = testMapper.add(test);
		log.info(i);
		log.info(test);
		return i;
	}

	@Override
	public int addTest2(TTest test) {
		int i = testMapper.add2(test);
		log.info(i);
		log.info(test);
		return i;
	}

	@Override
	public int updateTest(TTest test) {
		int i = testMapper.update(test);
		log.info(i);
		return  i;
	}

	@Override
	public int deleteTest(String id) {
		return testMapper.delete(id);
	}

	@Override
	public TTest getTestAuto(String id) {
		return testMapper.getEntityByIdAuto(id);
	}

	@Override
	public TTest getTestResult(String id) {
		return testMapper.getEntityByIdMapper(id);
	}

	@Override
	public List<TTest> queryTest() {
		return testMapper.queryAllEntity();
	}
}
