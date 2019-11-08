/**
 * 
 */
package com.in28minutes.springboot.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10661300
 *
 */

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByRole(String role);
	List<User> findByName(String name);
	List<User> findDistinctByName(String string);
}
