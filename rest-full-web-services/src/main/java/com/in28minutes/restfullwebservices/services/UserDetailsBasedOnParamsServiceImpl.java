/**
 * 
 */
package com.in28minutes.restfullwebservices.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.restfullwebservices.entities.UserDetailsBasedOnParams;
import com.in28minutes.restfullwebservices.pojos.UserDetailsBasedOnParamsPojo;
import com.in28minutes.restfullwebservices.repo.UserDetailsBasedOnParamsRepo;

/**
 * @author 10661300
 *
 */
@Service
@Transactional
public class UserDetailsBasedOnParamsServiceImpl implements IUserDetailsBasedOnParamsService{

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unused")
	@Autowired
	private UserDetailsBasedOnParamsRepo userDetailsBasedOnParamsRepo;
	
	@Override
	public List<UserDetailsBasedOnParams> findAllById(int userId) {
		// TODO Auto-generated method stub
		List<UserDetailsBasedOnParams> findAllById = userDetailsBasedOnParamsRepo.findAllById(userId);
		return findAllById;
	}

	@Override
	public void updateUserById(Integer userId, UserDetailsBasedOnParamsPojo basedOnParams) {
		// TODO Auto-generated method stub
		System.out.println("came to Service: :"+userId+", basedOnParams: "+basedOnParams.toString());
		System.out.println("Query: "+entityManager.createNamedQuery("updateDescById", UserDetailsBasedOnParams.class));
		TypedQuery<UserDetailsBasedOnParams> createNamedQuery = entityManager.createNamedQuery("updateDescById", UserDetailsBasedOnParams.class);
		//TypedQuery<UserDetailsBasedOnParams> createNamedQuery = entityManager.createNamedQuery("updateDescById", UserDetailsBasedOnParams.class);
		System.out.println("Executed Succesfully!"+createNamedQuery);
		createNamedQuery.setParameter("userName", basedOnParams.getUserName());
		createNamedQuery.setParameter("id",userId);
		createNamedQuery.executeUpdate();
	}

}
