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
public class HomeResource {

	@GetMapping("/")
	public String home() {
		return "<h1>Welcome Home</h1>";
	}
}
