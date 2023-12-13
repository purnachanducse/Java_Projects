package com.spring.security.configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.spring.security.model.RequestMatchers;
import com.spring.security.service.RequestMatchersService;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	
	@Autowired
	RequestMatchersService requestMatchersService;
	
	private static final String RESOURCE_ID = "resource-server-rest-api";
	private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
	private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
//	private static final String SECURED_PATTERN = "/secured/**";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		List<RequestMatchers> allPaths = requestMatchersService.getAllPaths();
		String endPointPathsStr ="",endPointMainPathsStr ="";
		if(allPaths != null) {
			
			Set<String> endPointMainPathSet = new HashSet<>();
			Set<String> contextPathSet = new HashSet<>();
			StringBuffer endPointPaths = new StringBuffer();
			allPaths.stream().forEach(obj -> {
				endPointPaths.append("\"").append(obj.getEndpointSubPath()).append("\"").append(",");
				endPointMainPathSet.add(obj.getEndpointMainPath());
				contextPathSet.add(obj.getContextPath());
			});
			endPointPathsStr = endPointPaths.toString();
			endPointPathsStr = endPointPathsStr.substring(0, endPointPathsStr.length() - 1).trim();
			System.out.println("endPointPaths: "+endPointPathsStr);
			
			StringBuffer endPointMainPaths = new StringBuffer();
			endPointMainPathSet.stream().forEach(str -> {
				endPointMainPaths.append("\"").append(str).append("\"").append(",");
			});
			endPointMainPathsStr = endPointMainPaths.toString();
			endPointMainPathsStr = endPointMainPathsStr.substring(0, endPointMainPathsStr.length() - 1).trim();
			System.out.println("endPointMainPathsStr: "+endPointMainPathsStr);
		}
		
		
//		 http.requestMatchers()
//		 .antMatchers(SECURED_PATTERN).and().authorizeRequests()
//		 .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
//		 .anyRequest().access(SECURED_READ_SCOPE);
		
//		http.antMatcher("/**").authorizeRequests().anyRequest().authenticated();
		
		//gstin-details/**,endPointMainPathsStr
		
//		http.getOrBuild().
		
//		http
//		//.addFilterBefore(new CibilAuthenticationFilter(), BasicAuthenticationFilter.class)
//		//.addFilterBefore(new CibilGatwayFilter(),GatewayFilter.class)
//		.requestMatchers()
//        .and()
//        .antMatcher("/**").authorizeRequests().anyRequest().authenticated()
//        .antMatchers(endPointMainPathsStr,"/oauth/users/**", "/oauth/clients/**").authenticated()
//        .antMatchers(endPointPathsStr).access(SECURED_READ_SCOPE)
//        .antMatchers(endPointPathsStr).access(SECURED_WRITE_SCOPE);
		/*
		http
		//.addFilterBefore(new CibilAuthenticationFilter(), BasicAuthenticationFilter.class)
		//.addFilterBefore(new CibilGatwayFilter(),GatewayFilter.class)
		.requestMatchers()
        .and()
        .antMatcher("/**").authorizeRequests()
        .antMatchers(endPointMainPathsStr,"/oauth/users/**", "/oauth/clients/**").permitAll()
//        .antMatchers(endPointMainPathsStr,"/oauth/users/**", "/oauth/clients/**","/oauth/token/*").permitAll()
//        .antMatchers(endPointPathsStr).access(SECURED_READ_SCOPE)
//        .antMatchers(endPointPathsStr).access(SECURED_WRITE_SCOPE)
        .anyRequest()
        .authenticated();*/
		
		
		http
//		.addFilterBefore(new CibilAuthenticationFilter(), BasicAuthenticationFilter.class)
		.requestMatchers()
        .and()
        .authorizeRequests()
//        .antMatchers(endPointMainPathsStr,"/**","/oauth/users/**", "/oauth/clients/**").authenticated()
        .antMatchers("/**").authenticated()
        .antMatchers("/auth/**").permitAll()
        .antMatchers(endPointMainPathsStr,"/oauth/users/**", "/oauth/clients/**").authenticated()
        .antMatchers(endPointPathsStr).access(SECURED_READ_SCOPE)
        .antMatchers(endPointPathsStr).access(SECURED_WRITE_SCOPE);
	}

}
