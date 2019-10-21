package com.boot.web.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userName,String password) {
		return (userName.equals("chandu") && password.equals("chandu"));
	}
}
