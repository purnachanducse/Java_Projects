/**
 * 
 */
package com.spring.security;
/*
import java.net.URI;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.spring.security.model.RequestMatchers;
import com.spring.security.service.RequestMatchersService;
import com.spring.security.service.RequestMatchersServiceImpl;

import reactor.core.publisher.Mono;
*/
/**
 * 
 */
/*
@RefreshScope
@Component
//@Order(-1)
public class CibilGatwayFilter implements GatewayFilter{//implements GlobalFilter
	
	private RequestMatchersService requestMatchersService;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		ApplicationContext webApplicationContext = exchange.getApplicationContext();
		// TODO Auto-generated method stub
		if(requestMatchersService==null){
            //ServletContext servletContext = request.getServletContext();
            //ebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            requestMatchersService = webApplicationContext.getBean(RequestMatchersServiceImpl.class);
        }
		
		String xAuth = request.getHeaders().get("Authorization").get(0);
		if(xAuth != null && xAuth.contains("Bearer")) {
			String[] chunks = xAuth.split("\\.");
			Base64.Decoder decoder = Base64.getUrlDecoder();
			
			// String header = new String(decoder.decode(chunks[0].trim()));
			String payload = new String(decoder.decode(chunks[1].trim()));
			// System.out.println("header: "+header);
			System.out.println("payload: " + payload);
			JSONObject jsonObj = new JSONObject(payload);
			String clientId = (String) jsonObj.get("client_id");
			System.out.println("clientId: " + clientId);
			if (clientId != null && !clientId.isEmpty()) {
				List<RequestMatchers> skippedEndPoints = requestMatchersService
						.findAllByClientIdAndIsInclude(clientId.trim(), "EXCLUDE");
				if (skippedEndPoints != null && !skippedEndPoints.isEmpty()) {
					for (RequestMatchers obj : skippedEndPoints) {
						String dbUriPath = obj.getEndpointMainPath() + obj.getEndpointSubPath();
						URI uri = request.getURI();
						System.out.println(
								"dbUriPath: " + dbUriPath + ", request.getRequestURI():" + uri.getPath());
						if (dbUriPath.equalsIgnoreCase(uri.getPath())) {
							//throw new ServletException("You do not have access to this page");
							return this.onError(exchange, "You do not have access to this page", HttpStatus.UNAUTHORIZED);
						}
					}
				}
			}
		}
		System.out.println("Filter came");
		return chain.filter(exchange);
	}
	
	 private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus)  {
	        ServerHttpResponse response = (ServerHttpResponse) exchange.getResponse();
	        response.setStatusCode(httpStatus);
	        return ((ReactiveHttpOutputMessage) response).setComplete();
	    }

}*/
