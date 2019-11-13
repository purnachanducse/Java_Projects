/**
 * 
 */
package com.in28minutes.learning.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.entities.User;

/**
 * @author 10661300
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
