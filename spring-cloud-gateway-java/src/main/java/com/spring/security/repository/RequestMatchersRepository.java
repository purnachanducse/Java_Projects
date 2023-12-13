/**
 * 
 */
package com.spring.security.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.RequestMatchers;

/**
 * 
 */
@Transactional
@Repository
public interface RequestMatchersRepository extends CrudRepository<RequestMatchers, BigInteger>{
	
	public List<RequestMatchers> findAllByClientIdAndIsInclude(String clientId, String isInclude);
	public List<RequestMatchers> findAllByClientId(String clientId);

}
