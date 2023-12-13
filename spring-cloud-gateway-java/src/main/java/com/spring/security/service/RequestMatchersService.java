/**
 * 
 */
package com.spring.security.service;

import java.util.List;

import com.spring.security.model.RequestMatchers;

/**
 * 
 */
public interface RequestMatchersService {

	public List<RequestMatchers> getAllPaths();

	public List<RequestMatchers> findAllByClientIdAndIsInclude(String clientId, String isInclude);

	public List<RequestMatchers> findAllByClientId(String clientId);

}
