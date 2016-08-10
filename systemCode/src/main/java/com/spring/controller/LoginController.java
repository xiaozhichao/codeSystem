package com.spring.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="member")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	/**
	 * √‹¬Î—È÷§
	 * @return
	 */
	@RequestMapping(value="check")
	public String index(){
		logger.info("ddd");
		return "login/login";
	}
	
	@RequestMapping(value="register")
	public String register(){
		return "login/login";
	}
}
