package com.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class IndexController {
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	private static final String LOGIN_ACTION = "login/checke";
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="")
	public ModelAndView index(){
		logger.info("ddd");
		ModelAndView model = new ModelAndView("login/login");
		model.addObject("url", "login/check");
		return model;
	}
	
	
}
