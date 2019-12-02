/**
 * 
 */
package com.in28minutes.restfullwebservices.services;

import java.util.List;
import java.util.Set;

import com.in28minutes.restfullwebservices.User;

/**
 * @author 10661300
 *
 */
public interface IUserRepoCustom {
	List<User> findUsersbyUser(Set<String> name);
}
