package com.duteliang.redis.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: zl
 * @Date: 2018-11-29 15:34
 */
@Slf4j
public class JackJsonUtil {

	private final static ObjectMapper objectMapper = new ObjectMapper();

	static {
		// 	对象所有字段全部列入序列化
		objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		//  取消默认转换timeStamps形式
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
		//  忽略空bean转json的错误
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//  所有日期格式的统一样式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		//  忽略在json字符串中存在，但是在java对象不存在对应的报错
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	}

	public static <T> String obj2String(T obj){
		if(obj == null){
			return null;
		}
		try {
			return obj instanceof String ? (String)obj : objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.warn("parse object to string error",e);
			return null;
		}
	}


	public static <T> String obj2StringPretty(T obj){
		if(obj == null){
			return null;
		}
		try {
			return obj instanceof String ? (String)obj :
					objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.warn("parse object to string error",e);
			return null;
		}
	}



	public static <T> T string2Obj(String str,Class<T> clazz){
		if(clazz == null || StringUtils.isEmpty(str)){
			return null;
		}
		try {
			return clazz.equals(String.class) ? (T)str : objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			log.warn("parse string to object error",e);
			return null;
		}

	}

	public static <T> T string2Obj(String str, TypeReference typeReference){
		if(typeReference == null || StringUtils.isEmpty(str)){
			return null;
		}
		try {
			return typeReference.getType().equals(String.class) ? (T)str : objectMapper.readValue(str, typeReference);
		} catch (IOException e) {
			log.warn("parse string to object error",e);
			return null;
		}

	}

	public static <T> T string2Obj(String str, Class<?> collectionClass,Class<?> ... elementClasses){
		if(collectionClass == null || elementClasses == null || StringUtils.isEmpty(str)){
			return null;
		}
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		try {
			return objectMapper.readValue(str, javaType);
		} catch (IOException e) {
			log.warn("parse string to object error",e);
			return null;
		}

	}



	public static void main(String[] args) throws ParseException {
		User user = new User();
		user.setId("1111");
		user.setIn(1111);
		user.setString("字符串衣蛾1111");
		user.setTime(new Date());
		user.setDate(DateUtils.parseDate("2018-11-29","yyyy-MM-dd"));

		User user2 = new User();
		user2.setId("2222");
		user2.setIn(2222);
		user2.setString("字符串衣蛾2222");
		user2.setTime(new Date());
		user2.setDate(DateUtils.parseDate("2018-11-22","yyyy-MM-dd"));

		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user2);

		String aa = JackJsonUtil.obj2String(users);
		List<User> vv = JackJsonUtil.string2Obj(aa, new TypeReference<List<User>>(){});
		log.info(vv.toString());

		List<User> gg = JackJsonUtil.string2Obj(aa,List.class,User.class);
		log.info(gg.toString());
		/*String string = JackJsonUtil.obj2String(user);
		log.info(string);

		log.info(JackJsonUtil.string2Obj(string, User.class).toString());

		String s = JackJsonUtil.obj2StringPretty(user);
		log.info(s);

		log.info(JackJsonUtil.string2Obj(s, User.class).toString());*/
	}







}
