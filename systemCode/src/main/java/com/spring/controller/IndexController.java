package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class IndexController {
	/**
	 * Ê×Ò³
	 */
	@RequestMapping(value="")
	public String index(){
		return "login/login";
	}
}
