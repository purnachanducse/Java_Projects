package com.boot.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("userName")
public class WelcomeController {
	
	//@Autowired
	//LoginService loginService;
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("userName", getLoggedinUserName());
		return "welcome";
	}
	
	public String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		
		return principal.toString();
	}

//	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
//	public String showLoginPage() {
//		return "login";
//	}
	
//	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
//	public String showWelcomePage(@RequestParam String userName,@RequestParam String password,ModelMap model) {
//		
//		boolean isValidUser = loginService.validateUser(userName, password);
//		if(!isValidUser) {
//			model.put("errorMessage","Invalid Credentials");
//			return "login";
//		}
//		model.put("userName",userName);
//		return "welcome";
//	}
}
