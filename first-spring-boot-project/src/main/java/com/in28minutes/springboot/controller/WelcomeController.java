/**
 * 
 */
package com.in28minutes.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.service.WelcomeService;

/**
 * @author 10661300
 *
 */
@RestController
public class WelcomeController {
	
	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return welcomeService.getMessage();
	}
}