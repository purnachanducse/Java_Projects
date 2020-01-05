package com.fastcollab.search.city.dao;

import java.util.List;

import com.fastcollab.search.city.model.AirportEntity;

/***
 * 
 * @author 10656321
 * Purpose : Interface to invoke Procedure
 *
 */
public interface SearchCityDao {
	List<AirportEntity> getcitiesByProcedure(String searchParm) ;
}
