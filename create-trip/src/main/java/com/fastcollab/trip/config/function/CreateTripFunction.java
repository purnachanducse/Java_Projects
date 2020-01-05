package com.fastcollab.trip.config.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fastcollab.trip.create.config.AplicationConfig;
import com.fastcollab.trip.create.dao.AirportRepository;
import com.fastcollab.trip.create.dao.CityRepo;
import com.fastcollab.trip.create.dao.CreateTripDao;
import com.fastcollab.trip.create.dto.AWSProxyRequest;
import com.fastcollab.trip.create.dto.AWSProxyResponse;
import com.fastcollab.trip.create.dto.CacheKeyDto;
import com.fastcollab.trip.create.dto.Flight;
import com.fastcollab.trip.create.entity.FlightOptions;
import com.fastcollab.trip.create.entity.FlightPassengers;
import com.fastcollab.trip.create.entity.FlightRequests;
import com.fastcollab.trip.create.entity.FlightSegments;
import com.fastcollab.trip.create.entity.JourneyDetails;
import com.fastcollab.trip.create.entity.SharedFlightOptions;
import com.fastcollab.trip.create.entity.TripMaster;
import com.fastcollab.trip.create.service.CreateTripService;
import com.fastcollab.trip.create.service.impl.PoolingServiceImpl;

/**
 * Lambda function that simply prints "Hello World" if the input String is not
 * provided, otherwise, print "Hello " with the provided input String.
 */
public class CreateTripFunction implements RequestHandler<AWSProxyRequest, AWSProxyResponse> {
	private static final Logger LOG = LogManager.getLogger(CreateTripFunction.class);
	private CacheKeyDto requestBody;

	@Override
	public AWSProxyResponse handleRequest(AWSProxyRequest request, Context context) {
		LOG.info("\"Search filter handler Started\"");
		context.getLogger().log("Search Filters handler Started");
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AplicationConfig.class)) {
			context.getLogger().log("Request object :" + request.getBody());
			context.getLogger().log("Request object :" + applicationContext);
			// context.ge

			return null;
		}

	}

	public static void main(String[] args) {
    	
    	Logger log = Logger.getLogger("CreateTripFunction.class");
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AplicationConfig.class)) {
			String flightKey="652d53be9a2c27d644a58ca630de9246";
			AnnotationConfigApplicationContext applicationContext = new
					  AnnotationConfigApplicationContext(AplicationConfig.class);
			PoolingServiceImpl poolingService = (PoolingServiceImpl)
					  applicationContext.getBean("poolingService");
			CreateTripService createTripService=(CreateTripService) context.getBean("tripService");
			String cacheKey="HYDBLR011120190";
			
			String autherizationToken="eyJraWQiOiI5MnF1MTZuNWw0VTdWdzlyQ1pMMDUxVTYxYkQ0MkhiVG04MGlQMWhOVnpZPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIxNzg1YmRmNS05Mzc3LTQ5NTktYjdlOC1iMGZlZjRmNmFmMDciLCJjb2duaXRvOmdyb3VwcyI6WyJkZXZlbG9wZXJzIl0sImV2ZW50X2lkIjoiN2MwYjlhZjQtOGNhZS00NTA2LTlkNzQtZWI2Mjk1NzQyNDQ0IiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTU3MDgwMzY1MywiaXNzIjoiaHR0cHM6XC9cL2NvZ25pdG8taWRwLmFwLXNvdXRoLTEuYW1hem9uYXdzLmNvbVwvYXAtc291dGgtMV9XdzN0eG5NYVkiLCJleHAiOjE1NzA4MDcyNTMsImlhdCI6MTU3MDgwMzY1MywianRpIjoiNmI1MWVkYzQtYTVjNi00ZjgwLTk2OTMtZmQwYzE0ZjlkNzJiIiwiY2xpZW50X2lkIjoiNzhiYXQ4dDVkMmZndTFycW8zMGszMDM1cGMiLCJ1c2VybmFtZSI6IjE3ODViZGY1LTkzNzctNDk1OS1iN2U4LWIwZmVmNGY2YWYwNyJ9.ekHHSIRi-GpFvkZ0rR5yL0H3WXlvRd_mm4jIdhNjhqrJBwiF3uH2BJx9zFKWH52H3uXLsyszv2_6tFzMlCgHSRTz33D2UL5DkqVz9xG9ya6jviIYBeSSGE3p41DxINK4NYSF-L1g_sckfnTcoiadYN2PZWviLYaKifprxW2HXgWLUg68xrVtlcabtxMcxDCW3ldfrzd_MGB8v0gg2PGi8JbuMKU6WNdowGuJkYVfwck155UsRXUfVPkjattz0RLWm3QFg9ysT95jK1koViZh8TrEuSvYGNhLWGqOHc5LhSrsH03dsAM4JT-Fp-U_t2fERu2N3WcUFoUmctD2jm-bQw";
				//	System.out.println("Result :"+ poolingService.getFlightDetails(cacheKey, autherizationToken));
					List<Flight> flights= poolingService.getFlights(cacheKey, autherizationToken); 
					System.out.println("flights"+flights);
					for (Flight flight : flights) {
						if(flight.getKey().equals(flightKey)){
							System.out.println(flight);
							createTripService.createApi(flight);
						}
						
					}
//					System.out.println("test");
			
			//Create trip data logic
			
			FlightRequests fRequests=new FlightRequests();
			JourneyDetails jd=new JourneyDetails();
			FlightOptions flightOptions=new FlightOptions();
			FlightSegments flightSegments=new FlightSegments();
			FlightPassengers flightPassengers=new FlightPassengers();
			SharedFlightOptions sharedFlightOptions=new SharedFlightOptions();
			
			List<FlightRequests> list=new ArrayList<>();
			List<JourneyDetails> journeyDetails=new ArrayList<>();
			List<FlightOptions> flightOptionsList=new ArrayList<>();
			List<FlightSegments> fSegmentList=new ArrayList<>();
			List<FlightPassengers> fPassangers=new ArrayList<>();
			List<SharedFlightOptions> sharedFlightOptionsList=new ArrayList<>();
			
			sharedFlightOptionsList.add(sharedFlightOptions);
			flightOptions.setSharedFlightOptions(sharedFlightOptionsList);
			
			fPassangers.add(flightPassengers);
			flightOptions.setFlightPassengers(fPassangers);
//			
			fSegmentList.add(flightSegments);
			flightOptions.setFlightSegments(fSegmentList);
//			
			journeyDetails.add(jd);
			flightOptionsList.add(flightOptions);
//			
			fRequests.setJourneyDetails(journeyDetails);
			fRequests.setFlightOptions(flightOptionsList);
			
			list.add(fRequests);
			TripMaster trip=new TripMaster();
			trip.setFlightRequests(list);
			//createTripService.createApi(trip);
			
			log.debug("Hello");
			List<String> codes=Arrays.asList("HYD","BNG");
			CityRepo cityRepo=(CityRepo) context.getBean("cityRepo");
			System.out.println(cityRepo.findByCityCode(codes));
			
			List<String> ariportcodes=Arrays.asList("RGIA","JFK");
			AirportRepository aiport=(AirportRepository) context.getBean("airportRepository");
			System.out.println(aiport.findByAirportCode(ariportcodes));
		}
	}
}