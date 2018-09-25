package com.duteliang.spring.mybatis.model;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-25 15:43
 */
@Table(name = "MYBATIS_A")
@Data
public class TMyBatisA {

	@Id
	@KeySql(useGeneratedKeys = true)
//	@KeySql(sql = "select uuid()", order = ORDER.BEFORE)
	private String id;

	private String name;

	private Integer num;

	private Date date;

}
