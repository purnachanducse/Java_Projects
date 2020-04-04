/**
 * 
 */
package com.exchangerate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exchangerate.service.CurrencyExchangeRateService;

/**
 * @author 10661300
 *
 */
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	CurrencyExchangeRateService service;

	@GetMapping("/")
	public String home() {
		return "<h1>Welcome Home</h1>";
	}
	
	@GetMapping("/user/*")
	public String UserHome() {
		return "<h1>Welcome User</h1>";
	}
	
	@GetMapping("/admin/*")
	public String AdminHome() {
		return "<h1>Welcome Admin</h1>";
	}
	
	@GetMapping("/user/currentRate")
	public String getCurrentRateData() {
		return service.getCurrentRateService();
	}
	
	@GetMapping("/user/pastRate")
	public List<String> getPastRateData() {
		return service.getPastRateService();
	}
}
