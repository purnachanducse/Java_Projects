package com.fastcollab.trip.create.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fastcollab.trip.create.entity.AirportEntity;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Integer>{
	
	@Query("SELECT DISTINCT a.airportName FROM AirportEntity a where a.airportCode IN :airportCodes")
	List<String> findByAirportCode(@Param("airportCodes") List<String> airportCodes);
	
	
}
