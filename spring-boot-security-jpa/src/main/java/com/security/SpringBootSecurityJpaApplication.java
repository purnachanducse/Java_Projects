package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.security.repo.UserRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class SpringBootSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJpaApplication.class, args);
	}

}
