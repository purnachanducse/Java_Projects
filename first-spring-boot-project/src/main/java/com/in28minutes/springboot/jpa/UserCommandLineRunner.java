/**
 * 
 */
package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author 10661300
 *
 */
@Component
public class UserCommandLineRunner implements CommandLineRunner{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user1 = new User("Purna", "Admin");
		User user2 = new User("Chandu", "User");
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		userRepository.findAll().stream().forEach(user -> LOGGER.info(user.toString()));
	}

}

