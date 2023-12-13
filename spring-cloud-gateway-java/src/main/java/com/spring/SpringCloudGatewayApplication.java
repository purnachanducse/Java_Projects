package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spring.security.CibilFilterFactory;

//(scanBasePackages = {"com.spring.*"})
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
//com.spring.security.CibilAuthenticationFilter
@ComponentScan({"com.spring"})
@EnableJpaRepositories("com.spring.security.repository")
@EntityScan("com.spring.security.model")
public class SpringCloudGatewayApplication {//implements ApplicationRunner

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}
	
//	public void run(ApplicationArguments args) throws Exception {
//
//    }
	
//	@Bean
//	public GlobalFilter requestFilter(){
//	   return new CibilGatwayFilter();
//	}
	

//	@Bean
//	public GatewayFilter requestFilter(){
//	   return new CibilGatwayFilter();
//	}
	
	@Bean
	public CibilFilterFactory requestFilter(){
	   return new CibilFilterFactory();
	}
	
//	@Bean
//	public GlobalAuthenticationFilter requestFilter() {
//		return new GlobalAuthenticationFilter();
//	}

}
