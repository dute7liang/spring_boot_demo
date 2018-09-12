package com.duteliang.spring.mybatis.service;

import com.duteliang.spring.mybatis.model.TUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-11 16:37
 */
@Service
public interface IUserService {

	int add(TUser user);

	int update(TUser user);

	int delete(String id);

	TUser getById(String id);

	List<TUser> queryUser();

	/**
	 * 分页查询数据
	 * @return
	 */
	List<TUser> queryUserPage();
}
