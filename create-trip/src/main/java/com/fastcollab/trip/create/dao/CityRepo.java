package com.fastcollab.trip.create.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fastcollab.trip.create.entity.CityEntity;

@Repository
public interface CityRepo extends JpaRepository<CityEntity, Integer>{
	@Query("SELECT DISTINCT c.cityName FROM CityEntity c where c.cityCode IN :cityCodes")
	List<String> findByCityCode(@Param("cityCodes") List<String> cityCodes);
	
	
	
}
