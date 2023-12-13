/**
 * 
 */
package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.repository.GstinDetailsRepository;

/**
 * 
 */
@Service
public class GstinDetailsImpl implements GstinDetailsService {

	//@Autowired
	GstinDetailsRepository gstinDetailsRepo;
}
