package com.xzc.code.junit.service;

import com.xzc.code.junit.entity.User;


public interface UserDao {
	 public User findUserByName(String name);

	 public User findBySid(Long sid);
}
