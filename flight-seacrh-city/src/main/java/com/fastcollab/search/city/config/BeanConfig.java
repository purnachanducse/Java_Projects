package com.fastcollab.search.city.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * 
 * @author 10656321
 *	Purpose : Instantiates registered beans
 */
@Configuration
public class BeanConfig {
	 @Bean
	    public ModelMapper modelMapper() {
	        return new ModelMapper();
	    }
}
