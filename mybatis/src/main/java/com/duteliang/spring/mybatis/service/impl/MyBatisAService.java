package com.duteliang.spring.mybatis.service.impl;

import com.duteliang.spring.mybatis.mapper.MyBatisAMapper;
import com.duteliang.spring.mybatis.model.TMyBatisA;
import com.duteliang.spring.mybatis.service.IMyBatisAService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-25 15:58
 */
@Service
@Transactional
public class MyBatisAService implements IMyBatisAService {

	@Autowired
	private MyBatisAMapper myBatisAMapper;

	public void add(TMyBatisA myBatisA){
		myBatisAMapper.insertSelective(myBatisA);
	}

	@Override
	public void edit(TMyBatisA myBatisA) {
		myBatisAMapper.updateByPrimaryKeySelective(myBatisA);
	}

	@Override
	public TMyBatisA getById(String id) {
		return myBatisAMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(String id) {
		myBatisAMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<TMyBatisA> getAll() {
		return myBatisAMapper.selectAll();
	}

	@Override
	public List<TMyBatisA> query(TMyBatisA myBatisA) {
		return myBatisAMapper.select(myBatisA);
	}

	@Override
	public List<TMyBatisA> dataGrid(TMyBatisA myBatisA) {
		PageHelper.startPage(1, 3, true);
		return myBatisAMapper.select(myBatisA);

	}
}
