package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class FirstSpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootProjectApplication.class, args);
	}

	/**
	 * Meaning of this one is this below bean will be created only in dev environment
	 * @return
	 */
	@Profile("dev")
	@Bean
	public String beanCreationAtProfileLevel() {
		return "dummy";
	}
}
