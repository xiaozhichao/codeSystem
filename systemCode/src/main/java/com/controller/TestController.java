package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("/aa")
    public String helloUser() {
       System.out.println("DD");
        return "index2";
    }
}
