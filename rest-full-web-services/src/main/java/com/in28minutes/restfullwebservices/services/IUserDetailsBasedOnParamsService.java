/**
 * 
 */
package com.in28minutes.restfullwebservices.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.in28minutes.restfullwebservices.entities.UserDetailsBasedOnParams;
import com.in28minutes.restfullwebservices.pojos.UserDetailsBasedOnParamsPojo;

/**
 * @author 10661300
 *
 */
public interface IUserDetailsBasedOnParamsService {
	List<UserDetailsBasedOnParams> findAllById(int userId);
	void updateUserById(@Param(value = "userId") Integer userId, UserDetailsBasedOnParamsPojo basedOnParams);
}
