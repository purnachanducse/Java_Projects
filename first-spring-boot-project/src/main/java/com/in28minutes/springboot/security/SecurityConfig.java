/**
 * 
 */
package com.in28minutes.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 10661300
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	protected void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("user")).roles("ADMIN","USER")
		.and()
		.withUser("admin").password("admin").roles("USER","ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/surveys/*").hasAuthority("USER")
		.antMatchers("/*").hasAuthority("ADMIN")
		.and().csrf().disable()
		.headers().frameOptions().disable();
		//.antMatchers("/surveys/**").access("USER")
		//.antMatchers("/**").access("ADMIN").and().formLogin();
	}
	
}
