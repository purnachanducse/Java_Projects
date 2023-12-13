/**
 * 
 */
package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import com.spring.security.CibilFilterFactory;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;


/**
 * @author Purnachandu.S
 *
 */
/*
@Configuration
public class SpringCloudGateway {
	
//	@Autowired
//	private CibilAuthenticationFilter cibilAuthenticationFilter;
	
//	@Autowired
//	private CibilGatwayFilter cibilGatwayFilter;
	
	@Autowired
	private CibilFilterFactory cibilFilterFactory;
	
//	@Autowired
//	private GlobalAuthenticationFilter authenticationFilter;

    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    	RouteLocator build = builder
    							.routes()
    							//.route(p -> p.host("internet.proxy.*****.com").and().path("http://localhost:9080//oauth/token/*")
    							.route("oauth-service",r -> r.path("/oauth/token/*")
    							//.route("oauth-service",r -> r.path("http://localhost:9080/oauth/token?scope=write&grant_type=client_credentials")
    							//.filters(f -> f.filter((GatewayFilter) cibilAuthenticationFilter))
    							//.filters(f -> f.filter((GatewayFilter) cibilGatwayFilter))
    						     .filters(f -> f.filter((GatewayFilter) cibilFilterFactory))
    							.uri("http://192.168.5.54:9080/oauth/token?scope=write&grant_type=client_credentials"))
		
    							//.route("student-service",r -> r.path("/service/student/**")
    							//.filters(f -> f.addRequestHeader("student-request", "student-request-header")
								//.addResponseHeader("student-response", "student-response-header"))
    							//.uri("lb://STUDENT-SERVICE/"))
    							//.uri("http://localhost:9081/"))
    							//.id("studentModule"))
						
				
    							.route(r -> r.path("/service/admin/*")
    							//.filters(f -> f.filter((GatewayFilter) cibilGatwayFilter))
    							//.filters(f -> f.rewritePath("/service/admin/(?<segment>.*)", "/$\\{segment}")
//    							.filters(f -> f.filter((GatewayFilter) cibilAuthenticationFilter))
    							.filters(f -> f.filter((GatewayFilter) cibilFilterFactory))
    							//.filters(f -> f.addRequestHeader("admin-request", "admin-request-header")
			    			    //.addResponseHeader("admin-response", "admin-response-header"))
			    		       //.uri("lb//ADMIN-SERVICE/"))
			    		         .uri("http://192.168.5.54:9082/"))
			    		        //.id("adminModule"))
			                      .build();//
    	return build;
	}
    
//    @Bean
//    public HttpClient httpClient() {
////    	HttpClient
//        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
//    }
    
    @Bean
    @Primary
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
	
}*/
