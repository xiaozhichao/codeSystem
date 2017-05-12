package com.fuminbank.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fuminbank.entity.SurfaceResultEntity;
import com.fuminbank.service.SurfaceDispatcherService;

@Controller
public class IndexController {
	private Logger logger =  LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private SurfaceDispatcherService surfaceDispatcherService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		logger.warn("IndexController.index.in");
		ModelAndView modelAndView=new ModelAndView("index");
		SurfaceResultEntity result = surfaceDispatcherService.getList();
		modelAndView.addObject("surfaceResult", result);
		logger.warn("IndexController.index.out_param: [" + JSON.toJSONString(result) + "]");
		return modelAndView;
	}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	
}
