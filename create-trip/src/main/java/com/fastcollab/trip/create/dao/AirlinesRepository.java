package com.fastcollab.trip.create.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.fastcollab.trip.create.entity.Airlines;

public interface AirlinesRepository extends CrudRepository<Airlines, Integer>{

	@Query("select airlineName from Airlines where airlineCode=:airlineCode")
	public String findAirlineNameByAirlineCode(@Param("airlineCode") String airlineCode);
}
