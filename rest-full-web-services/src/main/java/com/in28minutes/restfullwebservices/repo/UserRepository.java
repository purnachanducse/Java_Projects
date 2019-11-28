/**
 * 
 */
package com.in28minutes.restfullwebservices.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.restfullwebservices.User;

/**
 * @author 10661300
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
}
