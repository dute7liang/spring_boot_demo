package com.duteliang.spring.mybatis.mapper;


import com.duteliang.spring.mybatis.model.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TUserMapper {

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增数据
     * @param record
     * @return
     */
    int insert(TUser record);

    /**
     * 新增数据动态sql
     * @param record
     * @return
     */
    int insertSelective(TUser record);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    TUser selectByPrimaryKey(String id);

    /**
     * 更新数据动态sql
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TUser record);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(TUser record);


    List<TUser> queryAll(TUser user);
}