/**
 * 
 */
package com.in28minutes.learning.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.entities.User;

/**
 * @author 10661300
 *
 */
@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Long saveUser(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}
