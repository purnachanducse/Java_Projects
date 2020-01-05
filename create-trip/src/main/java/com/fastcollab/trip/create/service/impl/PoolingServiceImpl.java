
package com.fastcollab.trip.create.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fastcollab.searchfilters.beans.Airlines;
import com.fastcollab.searchfilters.beans.Price;
import com.fastcollab.searchfilters.beans.Stops;
import com.fastcollab.trip.create.dao.AirlinesRepository;
import com.fastcollab.trip.create.dto.FareOption;
import com.fastcollab.trip.create.dto.Flight;
import com.fastcollab.trip.create.dto.Segment;
import com.fastcollab.trip.create.enums.FCconstants;
import com.fastcollab.trip.create.util.FastCollabCommonUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Service implementation to prepare the search filter response
 *  @author Shrinivas P
 * @version 1.0.0
 * @since 09.10.19
 */

@Service("poolingService")
public class PoolingServiceImpl {
	private static final Logger LOG = LogManager.getLogger(PoolingServiceImpl.class);
	
	@Autowired 
	private Environment environment;
	
	@Autowired
	private AirlinesRepository airlinesRepository;
	JSONObject requestJson=new JSONObject();
    private Map<String,List<Map<String,Object>>> filtersMap = new HashMap<>();
    private Map<String,Object> stopMap = new HashMap<>();
    private Map<String,Object> airLineMap = new HashMap<>();
    private Map<String,Object> priceMap = new HashMap<>();
    private String resBody = "";
    private Double minPrice = 0.0;
    private Double airlineMinPrice = 0.0;
    private Double stopMinPrice = 0.0;
    private Double maxPrice = 0.0;
    private Price price = null;
    private Map<String, Integer> airlineCount = new HashMap<>();
    private Map<String, Double> airlineMinPriceMap = new HashMap<>();
    private Map<String, Double> stopMinPriceMap = new HashMap<>();
    private Map<String, Integer> stopCount = new HashMap<>();
    private List<Airlines> airlinesList = new ArrayList<Airlines>();
    private List<Stops> stopList = new ArrayList<>();
    private String airlineName = "";
    /**
     * 
     * Method is used to get the search filters
     * @param cacheKey
     * @return Map<String, List<Map<String, Object>>>
     * 
     */
	public Map<String, List<Map<String, Object>>> getFlightDetails(String cacheKey ,String autherizationToken/*,Context context */) {
		LOG.info("In getListFilters{}");
		LOG.info("cacheKey :"+cacheKey);
		if(null!=cacheKey || !(StringUtils.isEmpty(cacheKey))) {
		Instant start = Instant.now();
		HttpClient client = HttpClientBuilder.create().build();
		LOG.info("FlightPoolUrl {}:"+environment.getRequiredProperty("pool.base.url"));
		//context.getLogger().log("FlightPoolUrl {}:"+environment.getRequiredProperty("pool.base.url"));
		HttpPost request = new HttpPost(environment.getRequiredProperty("pool.base.url"));
				request.addHeader("Authorization",autherizationToken);
				request.addHeader("Content-Type",environment.getRequiredProperty("AWSContent-Type"));
				try {
					requestJson.put("cacheKey", cacheKey);
				} catch (JSONException e2) {
					e2.printStackTrace();
				}
				   StringEntity strEntity;
				try {
					strEntity = new StringEntity(requestJson.toString());
					 request.setEntity(strEntity);
					 HttpResponse response = client.execute(request);
					 Instant finish = Instant.now();
					 long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
					    HttpEntity entity = response.getEntity();
					    if (entity != null) {
							resBody = EntityUtils.toString(entity);
							LOG.info("Redis cache Response{}"+resBody);
							//context.getLogger().log("Pool response:"+resBody);
							filtersMap = flightPoolDataParse(resBody);
						}
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else {
			LOG.info("cacheKeyIsEmplty");
		}
		return filtersMap;
	}
	/**
	 * 
	 * 
	 * @param poolResponse
	 * @return Map<String,List<Map<String,Object>>>
	 * This method is used to give the filter response 
	 * 
	 */
	private Map<String,List<Map<String,Object>>> flightPoolDataParse(String poolResponse) {
		if(poolResponse!=null) {
			JsonObject jsonObject = new JsonParser().parse(poolResponse).getAsJsonObject();
			if(StringUtils.isEmpty(jsonObject.getAsJsonObject("payload")) ) {
				LOG.info("Flight payload can not be empty");
				stopMap.put(FCconstants.stops,new ArrayList<>());
            	airLineMap.put(FCconstants.airlines, new ArrayList<>());
            	//priceMap.put(FCconstants.price,new Price());
				 filtersMap.put("filters",Arrays.asList(stopMap,airLineMap,priceMap));
				 return filtersMap;
			}
			String flightPayload = jsonObject.getAsJsonObject("payload").get("flights").toString();
			try {
				List<Flight> flightList = Arrays.asList(FastCollabCommonUtil.getRequestBoby(flightPayload, Flight[].class));
				System.out.println("List of Flights:"+flightList.get(0));
				flightList.stream().forEach(flight->{
					System.out.println("Flight: "+flight);
					List<Segment>  segmentList = flight.getSegments();
					System.out.println("Segment list:"+segmentList);
					//stop count
					stopCount = stopCount(flight.getSegments().size());
					//get stop min price
					stopMinPriceMap = getStopMinPrice(flight.getSegments().size(),flight.getFareOption());
					//airline count
					airlineCount = getAirlineCount(flight.getSegments());
					//airline min price
					airlineMinPriceMap = getAirlineMinPrice(flight.getSegments(),flight.getFareOption());
					//min max price
					List<FareOption> fareOptionList = flight.getFareOption();
					Price price= getMinMaxPrice(flight.getFareOption());				
				});
				airlineCount.forEach((airlineName,airlineCount)->{
            		Airlines airlines = new Airlines();
            		airlines.setAirlineName(airlineName);
            		airlines.setCount(airlineCount);
            		airlineMinPriceMap.forEach((airlineNameKey,airlinePrice)->{
            			
            			if(airlineName.equals(airlineNameKey)){
            				airlines.setMinPrice(airlinePrice);
            			}
            		});
            		airlinesList.add(airlines);
            	});
            	stopCount.forEach((stopType,stopTypeCount)->{
            		Stops stops = new Stops();
            		stops.setStopType(stopType);
            		stops.setCount(stopTypeCount);
            		stopMinPriceMap.forEach((stopTypeKey,stopTypePrice)->{
            			
            			if(stopType.equals(stopTypeKey)){
            				stops.setMinPrice(stopTypePrice);
            			}
            		});
            		stopList.add(stops);
            	});
            	stopMap.put(FCconstants.stops, stopList);
            	airLineMap.put(FCconstants.airlines, airlinesList);
            	priceMap.put(FCconstants.price,price);
            	filtersMap.put("filters",Arrays.asList(stopMap,airLineMap,priceMap));
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e.getMessage());
			}
			
			
		}
		
		return filtersMap;
	}
/**
 * 
 * @param i
 * @param fareOptions
 * @return Map<String, Double>
 * Method is used to return the minimum price for the stops
 */
	private Map<String, Double> getStopMinPrice(int segmentListSize, List<FareOption> fareOptions) {
		fareOptions.stream().forEach(fareOption->{
			Double ticketPrice = fareOption.getFare().getTicketPrice();
			switch (segmentListSize) {
			case 1:
				if(stopMinPriceMap.containsKey(FCconstants.nonStop)) {
					
					if( stopMinPriceMap.get(FCconstants.nonStop) > ticketPrice) {
						stopMinPrice = ticketPrice;
						stopMinPriceMap.put(FCconstants.nonStop, stopMinPrice);
					}
			  	}else {
			  		stopMinPriceMap.put(FCconstants.nonStop, ticketPrice);
			  	  }
				break;
			case 2:
				if(stopMinPriceMap.containsKey(FCconstants.oneStop)) {
					
					if( stopMinPriceMap.get(FCconstants.oneStop) > ticketPrice) {
						stopMinPrice = ticketPrice;
						stopMinPriceMap.put(FCconstants.oneStop, stopMinPrice);
					}
			  	}else {
			  		stopMinPriceMap.put(FCconstants.oneStop, ticketPrice);
			  	  }
				break;

			default:
				if(stopMinPriceMap.containsKey(FCconstants.twoStops)) {
					
					if( stopMinPriceMap.get(FCconstants.twoStops) > ticketPrice) {
						stopMinPrice = ticketPrice;
						stopMinPriceMap.put(FCconstants.twoStops, stopMinPrice);
					}
			  	}else {
			  		stopMinPriceMap.put(FCconstants.twoStops, ticketPrice);
			  	  }
				break;
			}
			
		});
		return stopMinPriceMap;
	}
/**
 * 
 * @param segments
 * @param fareOptions
 * @return Map<String, Double>
 * method is used to return airline minimum price
 * 
 */
	private Map<String, Double> getAirlineMinPrice(List<Segment> segments,List<FareOption> fareOptions) {
		segments.stream().forEach(segment ->{
			fareOptions.stream().forEach(fareOption ->{
				airlineName = airlinesRepository.findAirlineNameByAirlineCode(segment.getAirline());
				Double	ticketPrice = fareOption.getFare().getTicketPrice();
				if(airlineMinPriceMap.containsKey(airlineName)) {
					
					if( airlineMinPriceMap.get(airlineName) > ticketPrice) {
						airlineMinPrice = ticketPrice;
						airlineMinPriceMap.put(airlineName, airlineMinPrice);
					}
			  	}else {
			  		airlineMinPriceMap.put(airlineName, ticketPrice);
			  	  }
			});
		});
		return airlineMinPriceMap;
	}
/**
 * 
 * @param segments
 * @return Map<String, Integer>
 * Method is used to return the airline count
 * 
 */
	private Map<String, Integer> getAirlineCount(List<Segment> segments) {
		segments.stream().forEach(segment ->{
			airlineName = airlinesRepository.findAirlineNameByAirlineCode(segment.getAirline());
			if(airlineCount.containsKey(airlineName)) {
		  		airlineCount.put(airlineName, airlineCount.get(airlineName)+1);
		  	}else {
		  		airlineCount.put(airlineName, 1);
		  	  }
		} );
		return airlineCount;
	}
/**
 * Method is used to get min and max price
 * @param fareOptions
 * @return
 */
	private Price getMinMaxPrice(List<FareOption> fareOptions) {
		fareOptions.stream().forEach(fareOption->{
			Double ticketPrice = fareOption.getFare().getTicketPrice();
			if(minPrice==0.0)
		  		minPrice = ticketPrice;
		  	if(minPrice > ticketPrice)
		  		minPrice = ticketPrice;
		  	if(maxPrice < ticketPrice)
		  		maxPrice = ticketPrice;
		});
		
		price = new Price();
		price.setMinPrice(minPrice);
		price.setMaxPrice(maxPrice);
		return price;
		
	}
/**
 * 
 * @param segmentListSize
 * @return Map<String, Integer>
 * Method is used to return stop count
 * 
 */
	private Map<String, Integer> stopCount(int segmentListSize) {
		switch (segmentListSize) {
		case 1:
			if (stopCount.containsKey(FCconstants.nonStop)) {
				stopCount.put(FCconstants.nonStop, stopCount.get(FCconstants.nonStop) + 1);
			} else {
				stopCount.put(FCconstants.nonStop, 1);
			}
			break;
		case 2:
			if (stopCount.containsKey(FCconstants.oneStop)) {
				stopCount.put(FCconstants.oneStop, stopCount.get(FCconstants.oneStop) + 1);
			} else {
				stopCount.put(FCconstants.oneStop, 1);
			}
			break;

		default:
			if (stopCount.containsKey(FCconstants.twoStops)) {
				stopCount.put(FCconstants.twoStops, stopCount.get(FCconstants.twoStops) + 1);
			} else {
				stopCount.put(FCconstants.twoStops, 1);
			}
			break;
		}
		return stopCount;

	}
	
	private List<Flight> getFlightList(String poolResponse) {
		List<Flight> flightList = Collections.emptyList();
		if(poolResponse!=null) {
			JsonObject jsonObject = new JsonParser().parse(poolResponse).getAsJsonObject();
			String flightPayload = jsonObject.getAsJsonObject("payload").get("flights").toString();
			try {
				flightList = Arrays.asList(FastCollabCommonUtil.getRequestBoby(flightPayload, Flight[].class));
				System.out.println("List of Flights:"+flightList.get(0).getFareOption());
				return flightList;
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error(e.getMessage());
			}
		}
		return flightList;
	}
	
	public List<Flight> getFlights(String cacheKey ,String autherizationToken/*,Context context */) {
		LOG.info("In getListFilters{}");
		LOG.info("cacheKey :"+cacheKey);
		List<Flight> flightList = Collections.emptyList();
		if(null!=cacheKey || !(StringUtils.isEmpty(cacheKey))) {
		Instant start = Instant.now();
		HttpClient client = HttpClientBuilder.create().build();
		LOG.info("FlightPoolUrl {}:"+environment.getRequiredProperty("pool.base.url"));
		//context.getLogger().log("FlightPoolUrl {}:"+environment.getRequiredProperty("pool.base.url"));
		HttpPost request = new HttpPost(environment.getRequiredProperty("pool.base.url"));
				request.addHeader("Authorization",autherizationToken);
				request.addHeader("Content-Type",environment.getRequiredProperty("AWSContent-Type"));
				try {
					requestJson.put("cacheKey", cacheKey);
				} catch (JSONException e2) {
					e2.printStackTrace();
				}
				   StringEntity strEntity;
				try {
					strEntity = new StringEntity(requestJson.toString());
					 request.setEntity(strEntity);
					 HttpResponse response = client.execute(request);
					 Instant finish = Instant.now();
					 long timeElapsed = Duration.between(start, finish).toMillis();  //in millis
					    HttpEntity entity = response.getEntity();
					    if (entity != null) {
							resBody = EntityUtils.toString(entity);
							LOG.info("Redis cache Response{}"+resBody);
							//context.getLogger().log("Pool response:"+resBody);
							return  getFlightList(resBody);
						}
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else {
			LOG.info("cacheKeyIsEmplty");
		}
		return flightList;
	}

}
