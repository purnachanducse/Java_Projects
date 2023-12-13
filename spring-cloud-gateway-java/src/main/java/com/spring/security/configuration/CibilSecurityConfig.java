package com.spring.security.configuration;

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
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.spring.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@PropertySource("classpath:application.yml")
public class CibilSecurityConfig  extends WebSecurityConfigurerAdapter{//implements ServletContextAware

	//@Value("${security.enable-csrf}")
   	//private boolean csrfEnabled;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	public CibilSecurityConfig(UserDetailsServiceImpl userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {//,"/gstin-details/**"
		//http.csrf(AbstractHttpConfigurer::disable);
//		if(csrfEnabled){
//			http.csrf().disable().cors().disable();
//		}
		http.csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/oauth/token").permitAll()
//		.authorizeRequests().antMatchers("/oauth/token","/service/admin").permitAll()
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

    // Duplicate one
    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
//		return authenticationManager();
	}

	
	  @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//	        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		  authenticationManagerBuilder.authenticationProvider(authenticationProvider()).userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	    }
	  
//	  @Autowired
//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//			auth.authenticationProvider(authenticationProvider());
//		}


    @Bean
    public SecurityWebFilterChain csrfFilterChain(ServerHttpSecurity http) throws Exception {
         http.csrf(csrf -> csrf.disable());
        return http.build();
    }

}