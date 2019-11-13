/**
 * 
 */
package com.in28minutes.learning.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.dao.UserDAOService;
import com.in28minutes.learning.jpa.entities.User;

/**
 * @author 10661300
 *
 */
@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	

	
	@Autowired
	private UserDAOService dao;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Jack","Admin");
		Long saveUser = dao.saveUser(user);
		log.info("new user created"+saveUser);
	}
	
	
}
