/**
 * 
 */
package com.in28minutes.restfullwebservices.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	
	//@Modifying
	//@Query(name = "insertUserQry",value = "insert into user (NAME,BIRTH_DATE) values ((?0),(?1))",nativeQuery = true)
	//@Query(name = "insertUserQry",value = "insert into USER (NAME,BIRTH_DATE) values (?,?)",nativeQuery = true)
	//void insertUser();
}
