/**
 * 
 */
package com.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.entities.User;

/**
 * @author 10661300
 * 
 */
public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);

}
