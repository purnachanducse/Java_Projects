/**
 * 
 */
package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.service.WelcomeService;

/**
 * @author 10661300
 *
 */
@RestController
public class WelcomeController {
	
	@Autowired
	WelcomeService welcomeService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return welcomeService.getMessage();
	}
}


