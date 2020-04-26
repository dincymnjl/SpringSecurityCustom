package com.springsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController
{
	@RequestMapping(value= {"/","/logoutSuccessful","/login"})
	public ModelAndView mainPage() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/welcome")
	public ModelAndView indexPagewelcome() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView indexPageadmin() {
		return new ModelAndView("admin");
	}

	
	@RequestMapping(value="/403")
	public ModelAndView indexPageerr() {
		return new ModelAndView("403");
	}
	
	
}
