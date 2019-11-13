/**
 * 
 */
package com.in28minutes.learning.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.dao.UserRepository;
import com.in28minutes.learning.jpa.entities.User;

/**
 * @author 10661300
 *
 */
@Component
public class UserDAORepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDAORepositoryCommandLineRunner.class);
	

	
	@Autowired
	private UserRepository dao;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Mill","User");
		User saveUser = dao.save(user);
		log.info("new user created"+saveUser);
		
		Optional<User> findById = dao.findById(1L);
		log.info("Single user retrieved: "+findById);
		
		List<User> findAll = dao.findAll();
		//System.out.print(findAll.forEach(user1 -> user1.toString()));
		log.info("All other users are: ");
		findAll.stream().forEach(user1 -> user1.toString());
		log.info(findAll.stream().iterator().next().toString());
	}
	
	
}
