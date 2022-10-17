package com.gl.caseStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.caseStudy.service.OurUsersService;


@RestController
public class LoginController {
	@Autowired
	private OurUsersService service;
	
	
	/*@GetMapping(value="/welcome")
	public ModelAndView showWelcomePage() {
		ModelAndView mv=new ModelAndView("welcome");
		return mv;
	}*/
	
	
	
	@GetMapping(value="/loginpage")
	 public ModelAndView showLoginPage() {
		 return new ModelAndView("loginPage");
	 }
	
	@GetMapping(value="/loginerror")
	 public ModelAndView showErrorPage() {
		 return new ModelAndView("errorPage");
	 }

}
