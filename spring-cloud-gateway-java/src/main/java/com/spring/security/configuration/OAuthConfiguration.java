package com.spring.security.configuration;

import java.util.Arrays;
import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.spring.security.service.UserInfoService;

@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UserInfoService userInfoService;

	@Bean
	public JdbcClientDetailsService jdbcClientDetailsService() {
		return new JdbcClientDetailsService(datasource);
	}

	@Override
	public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer
		.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

//	Need to uncomment for static client details
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory()
//		.withClient("fooClientId").secret("secret")
//		.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read","write")
//		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "USER","ADMIN")
//		.autoApprove(true)
//		.accessTokenValiditySeconds(180)//Access token is only valid for 3 minutes.
//        .refreshTokenValiditySeconds(600);//Refresh token is only valid for 10 minutes.;
//	}
//	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		BaseClientDetails clientDetails = new BaseClientDetails();
		
		if(jdbcClientDetailsService().listClientDetails().isEmpty()) {          
			clientDetails.setClientId("saidulu");
			clientDetails.setClientSecret("saidulu");
			clientDetails.setScope(Arrays.asList("read", "write"));
			clientDetails.setAuthorizedGrantTypes(Arrays.asList("client_credentials","password","authorization_code", "refresh_token"));
			//clientDetails.setAuthorities("ROLE_CLIENT, ROLE_TRUSTED_CLIENT, USER, ADMIN");
			clientDetails.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
			clientDetails.setAccessTokenValiditySeconds(21600);
			clientDetails.setRefreshTokenValiditySeconds(21600);
			jdbcClientDetailsService().addClientDetails(clientDetails);
		}
		clients.jdbc(datasource);
		clients.withClientDetails(jdbcClientDetailsService());
	}

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.accessTokenConverter(defaultAccessTokenConverter()).userDetailsService(userDetailsService);
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(defaultAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter defaultAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("123");
		return converter;
	}
}
