package com.fastcollab.trip.create.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fastcollab.trip.create.entity.TripMaster;

@Repository
public class CreateTripDaoImpl/* implements CreateTripDao */{
	@PersistenceContext
	private EntityManager entityManager;
	
	public String createApi(TripMaster master){
		entityManager.persist(master);
		return "Trip@1237";
	}
}
