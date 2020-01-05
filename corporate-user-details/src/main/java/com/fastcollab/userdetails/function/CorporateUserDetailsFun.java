package com.fastcollab.userdetails.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fastcollab.flightsearch.entities.UserDetailsEntity;
import com.fastcollab.userdetails.common.dto.UserDetailsSearchRequest;
import com.fastcollab.userdetails.common.enums.FCHttpStatus;
import com.fastcollab.userdetails.common.request.dto.AWSProxyRequest;
import com.fastcollab.userdetails.common.request.dto.AWSProxyResponse;
import com.fastcollab.userdetails.common.request.dto.FastCollabCommonUtil;
import com.fastcollab.userdetails.config.InstanceFactory;
import com.fastcollab.userdetails.service.IUserDetailsSearchCustom;
import com.fastcollab.userdetails.service.impl.UserDetailsSearchImpl;

/**
 * Lambda function that simply prints "Hello World" if the input String is not provided,
 * otherwise, print "Hello " with the provided input String.
 */
public class CorporateUserDetailsFun implements RequestHandler<AWSProxyRequest, AWSProxyResponse> {

	private static final Logger LOG = LogManager.getLogger(CorporateUserDetailsFun.class);
	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(InstanceFactory.class);
	public List<UserDetailsEntity> userDetailsList = Collections.emptyList();
	//IFlightSearch flightSearchService =  appContext.getBean(FlightSearchImpl.class);
	
	//@Autowired
	//private UserDetailsSearchRepository_JPA userDetailsSearchRepo;  
	
	@Override
	public AWSProxyResponse handleRequest(AWSProxyRequest input, Context context) {
		context.getLogger().log("Request body{}" + input.getBody());
		context.getLogger().log("Flight search function handler Started");
		LOG.info("User Details search function handler Started");
		
			try{
				
	    		UserDetailsSearchRequest requestBody = FastCollabCommonUtil.getRequestBoby(input.getBody(), UserDetailsSearchRequest.class);
				LOG.info("Search Input: " + FastCollabCommonUtil.getResponseBody(input));
				//userDetailsList = (List<UserDetailsEntity>)userDetailsSearchRepo.findAll();
				
				//System.out.println("flightUrlEntities: "+flightUrlEntities);
				//LOG.info("flightUrlEntities: "+flightUrlEntities);
	    		
	    		//context.getLogger().log(output);
	    		return new AWSProxyResponse("", FCHttpStatus.OK);
	    	}catch(Exception e){
	    		LOG.error("Flight Search exception ", e);
				//FlightSearchResponse response = new FlightSearchResponse(true, e.getMessage(), FCHttpStatus.INTERNAL_SERVER_ERROR.getCode());
				//return new AWSProxyResponse(response, FCHttpStatus.INTERNAL_SERVER_ERROR);
	    	}finally {
	    		//ctx.close();
			}
		
				return null;
	}
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(InstanceFactory.class);
		List<UserDetailsEntity> userDetailsEntities = new ArrayList<UserDetailsEntity>();
		IUserDetailsSearchCustom userDetailsSearchImpl = appContext.getBean(UserDetailsSearchImpl.class);
		UserDetailsSearchRequest userDetailsSearchRequest = new UserDetailsSearchRequest();
		//userDetailsSearchRequest.setSearchText("");
		userDetailsSearchRequest.setCorporateId("5");
		userDetailsEntities = (List<UserDetailsEntity>) userDetailsSearchImpl.getUserDetails(userDetailsSearchRequest);
		System.out.println("listOfUsers when findUserDetailsByCorporateId: "+userDetailsEntities);
	}
}