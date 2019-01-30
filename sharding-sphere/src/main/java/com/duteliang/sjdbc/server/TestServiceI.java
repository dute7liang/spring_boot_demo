package com.duteliang.sjdbc.server;

import java.util.List;
import java.util.Map;

/**
 * @author: zl
 * @Date: 2019-1-25 15:53
 */
public interface TestServiceI {

	void writeTest();


	List<Map<String, Object>> readTest();
}
