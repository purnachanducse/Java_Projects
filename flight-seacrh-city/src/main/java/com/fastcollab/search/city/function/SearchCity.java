package com.fastcollab.search.city.function;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fastcollab.search.city.config.JPAConfiguration;
import com.fastcollab.search.city.dto.AWSProxyRequest;
import com.fastcollab.search.city.dto.AWSProxyResponse;
import com.fastcollab.search.city.dto.CitySearchRequest;
import com.fastcollab.search.city.enums.FCHttpStatus;
import com.fastcollab.search.city.service.SearchCityService;
import com.fastcollab.search.city.util.FastCollabCommonUtil;

/**
 * Lambda function that simply prints "top 10 ranking cities" if the input String is not provided,
 * otherwise, print "list of cities " with the provided input String.
 */
public class SearchCity implements RequestHandler<AWSProxyRequest , AWSProxyResponse> {
	private static final Logger LOG = LogManager.getLogger(SearchCity.class);
	@Override
    public AWSProxyResponse handleRequest(AWSProxyRequest  request, Context context) {
		try(AnnotationConfigApplicationContext  applicationContext = new AnnotationConfigApplicationContext(JPAConfiguration.class)) {
				SearchCityService service=(SearchCityService) applicationContext.getBean("service");
				CitySearchRequest searchCity=FastCollabCommonUtil.getRequestBoby(request.getBody(), CitySearchRequest.class);
				context.getLogger().log("Requst {}"+request);
				context.getLogger().log("SearchCity: handleRequest SearchText"+searchCity.getSearchText());
				if(!StringUtils.isEmpty(searchCity.getSearchText())){
					return new AWSProxyResponse(service.getCitiesByProcedure(searchCity.getSearchText()), FCHttpStatus.OK);
				}
				else{
					context.getLogger().log("SearchCity: handleRequest else block-pathParameters"+searchCity.getSearchText());
					return new AWSProxyResponse(service.getCitiesByProcedure(""), FCHttpStatus.OK);
				}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(" exception handling SearchCity.handleRequest()", e);
			return new AWSProxyResponse(e.getMessage(), FCHttpStatus.INTERNAL_SERVER_ERROR);
			
		}
    }
}