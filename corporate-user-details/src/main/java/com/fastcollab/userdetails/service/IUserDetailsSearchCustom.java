/**
 * 
 */
package com.fastcollab.userdetails.service;

import java.util.List;

import com.fastcollab.flightsearch.entities.UserDetailsEntity;
import com.fastcollab.userdetails.common.dto.UserDetailsSearchRequest;

/**
 * @author Sapparapu
 *
 */
public interface IUserDetailsSearchCustom {
	List<UserDetailsEntity> getUserDetails(UserDetailsSearchRequest userDetailsSearchRequest);
}
