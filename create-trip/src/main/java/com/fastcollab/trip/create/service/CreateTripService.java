package com.fastcollab.trip.create.service;

import java.util.List;

import com.fastcollab.trip.create.dto.Flight;
import com.fastcollab.trip.create.entity.AirportEntity;
import com.fastcollab.trip.create.entity.CityEntity;
import com.fastcollab.trip.create.entity.TripMaster;

public interface CreateTripService {
	 //String createApi(TripMaster tripMaster);
	 String createApi(Flight flight);
	 TripMaster tripDtoToEntity(Flight flight );
	 List<String> findByCityCode(List<String> cityCodes);
	 List<String> findByAirportCode(List<String> airportCodes);
		 
	 }

