/**
 * 
 */
package com.in28minutes.restfullwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restfullwebservices.entities.UserDetailsBasedOnParams;
import com.in28minutes.restfullwebservices.pojos.UserDetailsBasedOnParamsPojo;
import com.in28minutes.restfullwebservices.services.UserDetailsBasedOnParamsServiceImpl;

/**
 * @author 10661300
 *
 */
@RestController
public class UserDetailsBasedOnParamsController {
	
	@Autowired
	private UserDetailsBasedOnParamsServiceImpl serviceImpl;
	
	@GetMapping("/jpaParams/users/{userId}")
	public List<UserDetailsBasedOnParams> getUserDetailsById(@PathVariable int userId) {
		List<UserDetailsBasedOnParams> userDetailsById = serviceImpl.findAllById(userId);
		return userDetailsById;
	}
	
	@PostMapping("/jpaParams/users/{userId}")
	public void updateUserNameById(@PathVariable int userId,@RequestBody UserDetailsBasedOnParamsPojo basedOnParams) {
		System.out.println("came to Controller");
		serviceImpl.updateUserById(userId, basedOnParams);
	}
}
