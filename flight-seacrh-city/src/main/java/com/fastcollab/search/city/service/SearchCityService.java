package com.fastcollab.search.city.service;

import java.util.List;

import com.fastcollab.search.city.dto.CiityDetailsDTO;

/***
 * 
 * @author 10656321
 * 
 *
 */
public interface SearchCityService {
	
	List<CiityDetailsDTO> getCitiesByProcedure(String searchParm);
	
}
