/**
 * 
 */
package com.in28minutes.springboot.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author 10661300
 *
 */
@RepositoryRestResource(path = "users",collectionResourceRel = "users")
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByRole(String role);
	List<User> findByName(String name);
	List<User> findDistinctByName(String string);
}
