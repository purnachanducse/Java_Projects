/**
 * 
 */
package com.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.model.RequestMatchers;
import com.spring.security.repository.RequestMatchersRepository;

/**
 * 
 */
@Service
public class RequestMatchersServiceImpl implements RequestMatchersService {

	@Autowired
	RequestMatchersRepository requestMatchersRepository;

	@Override
	public List<RequestMatchers> getAllPaths() {
		List<RequestMatchers> matchersList = (List<RequestMatchers>) requestMatchersRepository.findAll();
		return matchersList;
	}

	@Override
	public List<RequestMatchers> findAllByClientIdAndIsInclude(String clientId, String isInclude) {
		return requestMatchersRepository.findAllByClientIdAndIsInclude(clientId, isInclude);
	}

	@Override
	public List<RequestMatchers> findAllByClientId(String clientId) {
		return requestMatchersRepository.findAllByClientId(clientId);
	}

}
