package com.spring.controller;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entity.Test;
import com.spring.service.TestService;


@Controller
@RequestMapping(value="login")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
    private TestService testService ;
	/**
	 * √‹¬Î—È÷§
	 * @return
	 */
	@RequestMapping(value="check")
	public String index(){
		Test tests = testService.findAll();
		
		tests.toString();
		logger.info("ddd");
		return "login/login";
	}
	
	@RequestMapping(value="register")
	public String register(){
		return "login/login";
	}
}
