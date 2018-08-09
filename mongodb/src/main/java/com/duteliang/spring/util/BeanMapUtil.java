package com.duteliang.spring.util;

import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanMapUtil {
    private static Logger logger = Logger.getLogger(BeanMapUtil.class);
    private static final String BEAN_PROPERTY_NAME_CLASS = "class";
	public static Map<String, Object> bean2Map(Object object) throws Exception {
		Map<String, Object> map = new HashMap<>();
		BeanInfo bean;
		PropertyDescriptor[] properties;
		try {
			bean = Introspector.getBeanInfo(object.getClass());
			properties = bean.getPropertyDescriptors();
		} catch (IntrospectionException e1) {
			throw e1;
		}
		String propertyName;
		Method method;
		Object propertyValue;
		for(PropertyDescriptor property : properties){
			propertyName = property.getName();
			if(BEAN_PROPERTY_NAME_CLASS.equals(propertyName)) continue;
			method = property.getReadMethod();
			try {
				propertyValue = method.invoke(object);
				if(null != propertyValue){
					map.put(propertyName, propertyValue);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			    logger.error("程序执行异常！", e);
			}
		}
		return map;
	}
}
