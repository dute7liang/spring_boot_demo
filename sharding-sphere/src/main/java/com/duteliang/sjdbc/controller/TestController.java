package com.duteliang.sjdbc.controller;

import com.duteliang.sjdbc.server.TestServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: zl
 * @Date: 2019-1-25 16:03
 */
@RestController
public class TestController {

	@Autowired
	private TestServiceI testService;

	@GetMapping(value = "writeTest")
	public void writeTest(){
		testService.writeTest();
	}


	@GetMapping(value = "readTest")
	public List<Map<String, Object>> readTest(){
		return testService.readTest();
	}

}
