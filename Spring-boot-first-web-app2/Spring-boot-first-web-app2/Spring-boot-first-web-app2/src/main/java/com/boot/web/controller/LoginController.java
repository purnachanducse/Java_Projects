package com.boot.web.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.boot.web.services.LoginService;

@Controller
@SessionAttributes("userName")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public String showWelcomePage(@RequestParam String userName,@RequestParam String password,ModelMap model) {
		
		boolean isValidUser = loginService.validateUser(userName, password);
		if(!isValidUser) {
			model.put("errorMessage","Invalid Credentials");
			return "login";
		}
		model.put("userName",userName);
		return "welcome";
	}
}
