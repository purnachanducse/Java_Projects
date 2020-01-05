package com.fastcollab.search.city.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcollab.search.city.dao.SearchCityDao;
import com.fastcollab.search.city.dto.CiityDetailsDTO;
import com.fastcollab.search.city.model.AirportEntity;
import com.fastcollab.search.city.service.SearchCityService;

@Service("service")
@Transactional
public class SearchCityServiceImpl implements SearchCityService {
	
	@Autowired
	private SearchCityDao searchCityDao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<CiityDetailsDTO> getCitiesByProcedure(String searchParm) {
		List<AirportEntity> cities=searchCityDao.getcitiesByProcedure(searchParm);
		
		System.out.println("cities: "+cities);
		
		List<CiityDetailsDTO> citiesDTO =
			    cities
			        .stream()
			        .map(city -> modelMapper.map(city, CiityDetailsDTO.class))
			        .collect(Collectors.toList());
		return  citiesDTO;
	}

}
