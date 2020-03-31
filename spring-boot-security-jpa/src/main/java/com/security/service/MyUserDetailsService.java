/**
 * 
 */
package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entities.User;
import com.security.repo.UserRepo;

/**
 * @author 10661300
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Username Not Found" + userName));
		return user.map(MyUserDetails::new).get();
	}

}
