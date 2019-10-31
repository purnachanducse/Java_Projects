package com.in28minutes.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService{
	
	@Value("${welcome.msg}")
	private String str;
	
	public String getMessage() {
		return str;
	}
}