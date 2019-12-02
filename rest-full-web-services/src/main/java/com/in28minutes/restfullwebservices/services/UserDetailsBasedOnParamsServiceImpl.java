/**
 * 
 */
package com.in28minutes.restfullwebservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.restfullwebservices.User;
import com.in28minutes.restfullwebservices.entities.UserDetailsBasedOnParams;
import com.in28minutes.restfullwebservices.pojos.UserDetailsBasedOnParamsPojo;
import com.in28minutes.restfullwebservices.repo.UserDetailsBasedOnParamsRepo;

/**
 * @author 10661300
 *
 */
@Service
@Transactional
public class UserDetailsBasedOnParamsServiceImpl implements IUserDetailsBasedOnParamsService,IUserRepoCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDetailsBasedOnParamsRepo userDetailsBasedOnParamsRepo;
	
	@Override
	public List<UserDetailsBasedOnParams> findAllById(int userId) {
		// TODO Auto-generated method stub
		List<UserDetailsBasedOnParams> findAllById = userDetailsBasedOnParamsRepo.findAllById(userId);
		return findAllById;
	}
	
	public void insertUser(UserDetailsBasedOnParamsPojo insertUser) {
		entityManager.createNativeQuery("insert into USER (NAME,BIRTH_DATE) values (?,?)",UserDetailsBasedOnParams.class)
					.setParameter(1, insertUser.getId())
					.setParameter(2, insertUser.getUserName())
					.setParameter(3, insertUser.getBirthDate()).executeUpdate();
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

	@Override
	public List<User> findUsersbyUser(Set<String> names) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
		Root<User> user = query.from(User.class);
		
		Path<String> namePath = user.get("name");
		List<Predicate> predicates = new ArrayList<Predicate>();
		names.forEach(name1 -> predicates.add(criteriaBuilder.like(namePath, name1)));
		query.select(user).where(criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])));
		return entityManager.createQuery(query).getResultList();
	}

}
