/**
 * 
 */
package com.spring.security;

//import java.io.IOException;
//import java.util.Base64;
//import java.util.List;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONObject;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.spring.security.model.RequestMatchers;
//import com.spring.security.service.RequestMatchersService;

/**
 * 
 */
/*
@Component
public class CibilAuthenticationFilter extends OncePerRequestFilter {//implements GatewayFilter

	//Do not auto wire bean here because for the first time only bean will be injected after that null will come
	private RequestMatchersService requestMatchersService;

	


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(requestMatchersService==null){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            requestMatchersService = webApplicationContext.getBean(RequestMatchersService.class);
        }

		String xAuth = request.getHeader("Authorization");// here is your token value
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
						System.out.println(
								"dbUriPath: " + dbUriPath + ", request.getRequestURI():" + request.getRequestURI());
						if (dbUriPath.equalsIgnoreCase(request.getRequestURI())) {
							throw new ServletException("You do not have access to this page");
						}
					}
				}
			}
		}
		filterChain.doFilter(request, response);
	}


//	 @Override
//     protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//		 
//		 if(requestMatchersService==null){
//	            ServletContext servletContext = request.getServletContext();
//	            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
//	            requestMatchersService = webApplicationContext.getBean(RequestMatchersService.class);
//	        }
//		 // Populate excludeUrlPatterns on which one to exclude here
//		String xAuth = request.getHeader("Authorization");//here is your token value
//		String[] chunks = xAuth.split("\\.");
//		Base64.Decoder decoder = Base64.getUrlDecoder();
//
//		//String header = new String(decoder.decode(chunks[0].trim()));
//		String payload = new String(decoder.decode(chunks[1].trim()));
//		//System.out.println("header: "+header);
//		System.out.println("payload: "+payload);
//		JSONObject jsonObj = new JSONObject(payload);
//		String clientId = (String)jsonObj.get("client_id");
//		List<RequestMatchers> skippedEndPoints = requestMatchersService.findAllByClientIdAndIsInclude(clientId, "EXCLUDE");
//		System.out.println("URI: "+request.getRequestURI());
//		boolean anyMatch = skippedEndPoints.stream().anyMatch(e -> new AntPathMatcher().match(e.getEndpointMainPath()+e.getEndpointSubPath(), request.getRequestURI()));
//		return anyMatch;
//     }

}*/
