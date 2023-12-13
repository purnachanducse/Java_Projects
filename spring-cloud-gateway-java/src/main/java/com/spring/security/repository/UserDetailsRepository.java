package com.spring.security.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.UserInfo;

@Transactional
@Repository
public interface UserDetailsRepository extends CrudRepository<UserInfo, Integer> {
	public UserInfo findByUserNameAndEnabled(String userName, short enabled);
	
	public UserInfo findByUserNameAndPasswordAndEnabled(String userName, String password,short enabled);

	public List<UserInfo> findAllByEnabled(short enabled);

//	public UserInfo findById(Integer id);
	
	public Optional<UserInfo> findById(Integer id);

//	@Override
//	public UserInfo save(UserInfo userInfo);

	public void deleteById(Integer id);
}
