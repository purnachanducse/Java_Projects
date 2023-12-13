package com.spring.security.configuration;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.spring.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@PropertySource("classpath:application.yml")

public class SecurityConfig extends WebSecurityConfigurerAdapter {//implements ServletContextAware

	//@Value("${security.enable-csrf}")
   	//private boolean csrfEnabled;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {//,"/gstin-details/**"
		//http.csrf(AbstractHttpConfigurer::disable);
//		if(csrfEnabled){
			http.csrf().disable().cors().disable();
//		}
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
				.authorizeRequests()
					.antMatchers("/oauth/token/*","/service/admin").permitAll()
					//.and()
				//.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/user").hasRole("ADMIN")
					.anyRequest().authenticated()
					;
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder());
//		provider.setPasswordEncoder(new PlaintextPasswordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

//	@Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//        .withUser("bill").password("abc123").roles("ADMIN").and()
//        .withUser("bob").password("abc123").roles("USER");
//    }

	// Need to uncomment
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		//return new BCryptPasswordEncoder();
//		 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//	}

	// Duplicate one
	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		// return new BCryptPasswordEncoder();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	 @Bean
    public SecurityWebFilterChain csrfFilterChain(ServerHttpSecurity http) throws Exception {
        http.csrf().disable();
        //http.authorizeExchange((exchange) -> exchange.anyExchange().authenticated());
        //http.authorizeExchange().anyExchange().authenticated();
        //http.oauth2Login(withDefaults());
        //http.oauth2Client(withDefaults());
        return http.build();
//        return http.getOrBuild();
    }

}*/