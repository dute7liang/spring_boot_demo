package com.duteliang.spring.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-8 17:45
 */
@Document(collection = "MONGO_TEST")
@Data
@ToString
public class MongoPo {

	private String id;

	private String name;

	private Integer height;

	private Date birthday;

	private Double grade;

	private String code;


}
