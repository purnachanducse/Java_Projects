/**
 * 
 */
package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10661300
 *
 */
@RestController
public class HomeContorller {
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}
}
