/**
 * 
 */
package com.fastcollab.userdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcollab.flightsearch.entities.UserDetailsEntity;
import com.fastcollab.userdetails.service.IUserDetailsSearchCustom;

/**
 * @author Sapparapu
 *
 */
@Repository
public interface UserDetailsSearchRepository extends JpaRepository<UserDetailsEntity, String>{

}
