package com.fastcollab.userdetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages={"com.fastcollab.userdetails"})
@Import(JpaConfiguration.class)
public class InstanceFactory {
	
	@Bean
	public ObjectMapper getObjectMapper(){
		return new ObjectMapper();
	}
	
	
}
