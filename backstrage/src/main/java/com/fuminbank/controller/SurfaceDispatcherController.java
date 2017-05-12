package com.fuminbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fuminbank.entity.QueryParams;
import com.fuminbank.entity.SurfaceParamsEntity;
import com.fuminbank.service.SurfaceDispatcherService;


@Controller
@RequestMapping("/surface/dispatcher")
public class SurfaceDispatcherController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SurfaceDispatcherService surfaceDispatcherService;
	
	@RequestMapping("index")
	public ModelAndView index(QueryParams queryParams) throws Exception{
		logger.warn("SurfaceDispatcherController.index.in_param:[" +JSON.toJSONString(queryParams)+ "]");
		ModelAndView model = new ModelAndView("dispatcher/index");
		SurfaceParamsEntity paramsEntity = surfaceDispatcherService.getParams(queryParams.getId());
		model.addObject("url", queryParams.getUrl());
		model.addObject("businessCode", queryParams.getBusinessCode());
		model.addObject("parentName", queryParams.getParentName());
		model.addObject("subName", queryParams.getSubName());
		model.addObject("surfaceResult", paramsEntity);
		logger.warn("SurfaceDispatcherController.index.out_param: [" + JSON.toJSONString(paramsEntity) + "]");
		return model;
	}
}

	