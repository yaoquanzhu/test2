package com.yc.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	
	@RequestMapping(value="/index.action",method=RequestMethod.GET)
	public String index(){
		return "login";
		//return "/WEB-INF/page/login.jsp";
	}
	
	
	@RequestMapping(value="/toRegister.action",method=RequestMethod.GET)
	public String toRegister(){
		return "register";
	}
	

	
}







































