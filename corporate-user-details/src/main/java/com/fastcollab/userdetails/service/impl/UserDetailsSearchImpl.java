/**
 * 
 */
package com.fastcollab.userdetails.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fastcollab.flightsearch.entities.UserDetailsEntity;
import com.fastcollab.userdetails.common.dto.UserDetailsSearchRequest;
import com.fastcollab.userdetails.service.IUserDetailsSearchCustom;

/**
 * @author 10661300
 *
 */
@Service
//@Transactional
public class UserDetailsSearchImpl implements IUserDetailsSearchCustom{

	private List<UserDetailsEntity> userDetailsEntities = Collections.emptyList();
	
	//@Autowired
	//private UserDetailsSearchRepository userDetailsSearchRepo;
	
	@Autowired
	private EntityManager entityManagerFactoryBean;
	
	public UserDetailsSearchImpl() {
		super();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetailsEntity> getUserDetails(UserDetailsSearchRequest userDetailsSearchRequest) {
		// TODO Auto-generated method stub
		StoredProcedureQuery findByCorporateIdAndFNameOrLNameOrEmail = entityManagerFactoryBean
				.createNamedStoredProcedureQuery("getAllUserDetails");
		System.out.println("userDetailsSearchRequest: "+userDetailsSearchRequest.toString());
		if(!StringUtils.isEmpty(userDetailsSearchRequest.getCorporateId())) {
			//System.out.println("came to getCorporateId: "+userDetailsSearchRequest.getCorporateId());
			findByCorporateIdAndFNameOrLNameOrEmail.setParameter("corporateId", userDetailsSearchRequest.getCorporateId());
			if(!StringUtils.isEmpty(userDetailsSearchRequest.getUserId())){
				//System.out.println("came to getUserID: "+userDetailsSearchRequest.getUserId());
				findByCorporateIdAndFNameOrLNameOrEmail.setParameter("searchText", userDetailsSearchRequest.getUserId());
			}else if(!StringUtils.isEmpty(userDetailsSearchRequest.getSearchText())){
				//System.out.println("came to getSearchText: "+userDetailsSearchRequest.getSearchText());
				findByCorporateIdAndFNameOrLNameOrEmail.setParameter("searchText", userDetailsSearchRequest.getSearchText());
			}else {
				//System.out.println("came to else");
				findByCorporateIdAndFNameOrLNameOrEmail.setParameter("searchText", "");
			}
		}
		return findByCorporateIdAndFNameOrLNameOrEmail.getResultList();
	}
	
	
	
}
