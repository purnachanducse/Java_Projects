/**
 * 
 */
package com.in28minutes.restfullwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

/**
 * @author 10661300
 *
 */
@Component
public class UserDAOService {

	private static List<User> usersList = new ArrayList<User>();
	private int counter = Integer.MIN_VALUE;
	static {
		usersList.add(new User(1,"Purna",new Date()));
		usersList.add(new User(2,"Chandu",new Date()));
		usersList.add(new User(3,"Purna",new Date()));
	}
	
	public List<User> findAll(){
		return usersList;
	}
	
	public Optional<User> findOne(int userId) {
		Predicate<User> condition = user -> (user.getId() == userId);
		return usersList.stream().filter(condition).findAny();
	}
	
//	public User updateUser() {
//		
//	}
	
	public User addUser(User user) {
		if(user.getId() == null) {
			int listSize = usersList.size();
			counter = (usersList.get(listSize-1).getId())+1;
			user.setId(counter);
		}
		usersList.add(user);
		return user;
	}
	
	public void delete(int userId) {
		Predicate<User> condition = user -> (user.getId() == userId);
		usersList.removeIf(condition);
	}
}
