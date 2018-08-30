package com.duteliang.spring.mvc.service;

import com.duteliang.spring.mvc.model.TUser;

import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-14 17:47
 */
public interface IUserService {

	TUser add(TUser user) throws Exception;

	void update(TUser user) throws Exception;

	TUser dataDetail(String id) throws Exception;

	void delete(String id) throws Exception;

	List<TUser> queryList(TUser user) throws Exception;

	TUser getUser(String password,String username) throws Exception;

}
