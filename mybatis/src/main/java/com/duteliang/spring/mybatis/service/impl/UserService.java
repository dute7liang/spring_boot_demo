package com.duteliang.spring.mybatis.service.impl;

import com.duteliang.spring.mybatis.mapper.TUserMapper;
import com.duteliang.spring.mybatis.model.TUser;
import com.duteliang.spring.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-11 16:39
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private TUserMapper userMapper;

	@Override
	public int add(TUser user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int update(TUser user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TUser getById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<TUser> queryUser() {
		return userMapper.queryAll(null);
	}

	@Override
	public List<TUser> queryUserPage() {
		return null;
	}
}
