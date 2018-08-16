package com.duteliang.spring.mvc.util;

import java.util.UUID;

public class UuidGeneratorUtil {

	public static String generateId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
