/**
 * 
 */
package com.in28minutes.restfullwebservices.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.restfullwebservices.User;
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
	
	@GetMapping("/jpaParams/users/{userName}")
	public List<User> getUserDetailsByName(@PathVariable String userName) {
		Set<String> userNames = new HashSet<String>();
		userNames.add(userName);
		List<User> userDetailsByName = serviceImpl.findUsersbyUser(userNames);
		return userDetailsByName;
	}
	
	@PostMapping("/jpaParams/users")
	public void insertUserName(@RequestBody UserDetailsBasedOnParamsPojo basedOnParams) {
		System.out.println("came to Controller");
		serviceImpl.insertUser(basedOnParams);
	}
	
	@PostMapping("/jpaParams/users/{userId}")
	public void updateUserNameById(@PathVariable int userId,@RequestBody UserDetailsBasedOnParamsPojo basedOnParams) {
		System.out.println("came to Controller");
		serviceImpl.updateUserById(userId, basedOnParams);
	}
}
