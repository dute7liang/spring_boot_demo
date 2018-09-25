package com.duteliang.spring.mybatis.mapper;

import com.duteliang.spring.mybatis.model.TMyBatisA;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description:
 * @Auther: zl
 * @Date: 2018-9-25 15:43
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface MyBatisAMapper extends Mapper<TMyBatisA> {
}
