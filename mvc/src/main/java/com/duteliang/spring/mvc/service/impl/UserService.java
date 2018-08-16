package com.duteliang.spring.mvc.service.impl;

import com.duteliang.spring.mvc.model.TUser;
import com.duteliang.spring.mvc.service.IUserService;
import com.duteliang.spring.mvc.util.UuidGeneratorUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-8-14 17:52
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public TUser add(TUser user) throws Exception {
		Assert.notNull(user, "user is must not null");
		String id = UuidGeneratorUtil.generateId();
		String sql = "INSERT user(id,name,age,birthday) value(?,?,?,?)";
		jdbcTemplate.update(sql, id,user.getName(),user.getAge(),user.getBirthday());
		user.setId(id);
//		int i = 5/0;
		return user;
	}

	@Override
	public void update(TUser user) throws Exception {
		Assert.notNull(user, "user is must not null");
		Assert.notNull(user.getId(), "user.id is must not null");
		String sql = "UPDATE USER SET NAME = ? AND AGE = ? AND BIRTHDAY = ? WHERE ID = ?";
		jdbcTemplate.update(sql, user.getName(),user.getAge(),user.getBirthday(),user.getId());
	}

	@Override
	public TUser dataDetail(String id) throws Exception {
		Assert.notNull(id, "id is must not null");
		String sql = "SELECT * FROM USER WHERE ID = ?";
		RowMapper<TUser> rowMapper = new BeanPropertyRowMapper<>(TUser.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,id);
	}

	@Override
	public void delete(String id) throws Exception {
		Assert.notNull(id, "id is must not null");
		String sql = "DELETE FROM USER WHERE ID = ?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public List<TUser> queryList(TUser user) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<>();
		sql.append("SELECT * FROM USER WHERE 1=1 ");
		if(user != null){
			if(StringUtils.isNotEmpty(user.getName())){
				sql.append(" AND NAME = ?");
				params.add(user.getName());
			}
			if(user.getAge() != null){
				sql.append(" AND AGE = ?");
				params.add(user.getAge());
			}
			if(user.getBirthday() != null){
				sql.append(" AND BIRTHDAY = ?");
				params.add(user.getBirthday());
			}
		}
		RowMapper<TUser> rowMapper = new BeanPropertyRowMapper<>(TUser.class);
		return  jdbcTemplate.query(sql.toString(),rowMapper, params.toArray());
	}
}
