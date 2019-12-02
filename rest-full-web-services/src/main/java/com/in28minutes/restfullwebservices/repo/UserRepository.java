/**
 * 
 */
package com.in28minutes.restfullwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restfullwebservices.User;
import com.in28minutes.restfullwebservices.services.IUserRepoCustom;

/**
 * @author 10661300
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,IUserRepoCustom{
	
}
