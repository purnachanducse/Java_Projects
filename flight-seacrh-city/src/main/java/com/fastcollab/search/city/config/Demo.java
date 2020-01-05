package com.fastcollab.search.city.config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fastcollab.search.city.dto.AWSProxyResponse;
import com.fastcollab.search.city.dto.CiityDetailsDTO;
import com.fastcollab.search.city.enums.FCHttpStatus;
import com.fastcollab.search.city.service.SearchCityService;

public class Demo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext(JPAConfiguration.class);
		SearchCityService service=(SearchCityService) context.getBean("service");
		List<CiityDetailsDTO> dtos=service.getCitiesByProcedure("BOM");//getCitiesByProcedure(false);
		System.out.println(dtos.size());
		System.out.println(dtos);
		AWSProxyResponse response=new AWSProxyResponse(dtos, FCHttpStatus.OK);
		System.out.println(response.getBody()+":\n"+response);
		
	}

}








