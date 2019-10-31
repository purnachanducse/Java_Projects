/**
 * 
 */
package com.in28minutes.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configuration.DynamicConfiguration;
import com.in28minutes.springboot.service.WelcomeService;

/**
 * @author 10661300
 *
 */
@RestController
public class WelcomeController {
	
	@Autowired
	private WelcomeService welcomeService;
	
	@Autowired
	private DynamicConfiguration dynamicConfiguration;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return welcomeService.getMessage();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/dynamic-configuration")
	public Map dynamicConfiguration() {
		Map map = new HashMap();
		map.put("value", dynamicConfiguration.isValue());
		map.put("message", dynamicConfiguration.getMessage());
		map.put("number", dynamicConfiguration.getNum());
		
		return map;
	}
}