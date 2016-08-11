package com.spring.dao;

import java.util.List;

import com.spring.entity.Test;

public interface ITestDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
}
