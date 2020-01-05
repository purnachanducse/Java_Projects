package com.fastcollab.search.city.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.fastcollab.search.city.dao.SearchCityDao;
import com.fastcollab.search.city.model.AirportEntity;

/***
 * 
 * @author 10656321
 * Purpose : Implementation class for SearchCityDao
 *
 */
@Repository
public class SearchCityDaoImpl implements SearchCityDao{

	 @PersistenceContext
	 private EntityManager entityManager;
	
	 /***
	  * Purpose : Retrieves City,Country & Airport details by invoking GetCities procedure 
	  * @Parm : searchParm
	  */
	@SuppressWarnings("unchecked")
	@Override
	public List<AirportEntity> getcitiesByProcedure(String searchParm) {
		
		StoredProcedureQuery procedureQuery = entityManager.createNamedStoredProcedureQuery("citiesDetails");
		procedureQuery.setParameter("parSearch",searchParm);
		return procedureQuery.getResultList();
	}
}
