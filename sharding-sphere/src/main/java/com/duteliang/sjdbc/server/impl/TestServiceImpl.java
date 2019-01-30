package com.duteliang.sjdbc.server.impl;

import com.duteliang.sjdbc.server.TestServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: zl
 * @Date: 2019-1-25 15:54
 */
@Service
public class TestServiceImpl implements TestServiceI {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void writeTest() {
		String sql = "INSERT INTO test(NAME,AGE) VALUES(?,?)";
		jdbcTemplate.update(sql,"NAME",55);
	}


	public List<Map<String, Object>> readTest(){
		String sql = "select * from test";
		return jdbcTemplate.queryForList(sql);
	}
}
