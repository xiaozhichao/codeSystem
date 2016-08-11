package com.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.TestMapper;
import com.spring.entity.Test;
import com.spring.service.TestService;
@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
    private TestMapper testMapper ;

	@Override
	public Test findAll() {
		// TODO Auto-generated method stub
		return testMapper.selectByPrimaryKey(1);
	}
	
	
}
