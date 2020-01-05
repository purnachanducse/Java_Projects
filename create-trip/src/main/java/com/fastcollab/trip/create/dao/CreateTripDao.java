package com.fastcollab.trip.create.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastcollab.trip.create.entity.TripMaster;


public interface CreateTripDao extends JpaRepository<TripMaster, Long>{
	 String createApi(TripMaster master);
	 
	 
	 

}
