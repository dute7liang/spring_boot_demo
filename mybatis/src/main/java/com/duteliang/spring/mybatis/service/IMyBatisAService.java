package com.duteliang.spring.mybatis.service;

import com.duteliang.spring.mybatis.model.TMyBatisA;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-25 15:57
 */
public interface IMyBatisAService {

	void add(TMyBatisA myBatisA);

	void edit(TMyBatisA myBatisA);

	TMyBatisA getById(String id);

	void deleteById(String id);

	List<TMyBatisA> getAll();

	List<TMyBatisA> query(TMyBatisA myBatisA);


	List<TMyBatisA> dataGrid(TMyBatisA myBatisA);
}
