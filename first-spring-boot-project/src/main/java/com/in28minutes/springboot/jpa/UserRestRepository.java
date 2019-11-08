/**
 * 
 */
package com.in28minutes.springboot.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author 10661300
 *
 */
@RepositoryRestResource(path = "users",collectionResourceRel = "users")
public interface UserRestRepository extends JpaRepository<User, Long>{
	List<User> findByRole(@Param("role") String role);
	List<User> findByName(@Param("role")String name);
	List<User> findDistinctByName(@Param("role")String string);
}
