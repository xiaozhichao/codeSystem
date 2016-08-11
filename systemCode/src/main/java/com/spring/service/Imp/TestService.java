package com.spring.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.ITestDao;
import com.spring.entity.Test;
import com.spring.service.ITestService;
@Service("testService")
public class TestService implements ITestService {
	@Autowired
    private ITestDao testDao ;
	
	@Override
	public List<Test> findAll() {
		
		return testDao.findAll();
	}

}
