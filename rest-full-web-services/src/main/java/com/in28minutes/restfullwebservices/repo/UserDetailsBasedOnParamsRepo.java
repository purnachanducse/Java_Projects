/**
 * 
 */
package com.in28minutes.restfullwebservices.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in28minutes.restfullwebservices.entities.UserDetailsBasedOnParams;

/**
 * @author 10661300
 *
 */
@Repository
public interface UserDetailsBasedOnParamsRepo extends JpaRepository<UserDetailsBasedOnParams, Integer>{
	List<UserDetailsBasedOnParams> findAllById(@Param(value = "userId") Integer userId); 
	//void updateUserById(@Param(value = "userId") Integer userId, UserDetailsBasedOnParams basedOnParams);
}
