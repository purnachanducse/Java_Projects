package com.fastcollab.trip.create.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5370519041250238988L;
	
	
	//Trip details
	private String cacheKey;
	private Long userId;
	private Integer statusId;
	private String tripId;
	private String flightKey;
	private String fareKey;
	private List<JourneyDetails> journeyDetails;
	private List<FlightPassengers> flightPassengers;
	//Pool response
	private String key;
	private int travelMode;//Flight_Request.Travel_Mode
	private int travelType;//Flight_Request.Travel_Type
	private Integer tripIndicator;//flight_options.Trip_Indicator
	private String validatingAirline;// flight_options.Airline_Name
	private boolean isLCC;
	private String airCraft;//Flight_options.Airline_Code
	private String fareBasisCode;//Flight_options.Fare_BasisCode
	private Integer noOfSeatsAvailability;
	private List<Segment> segments = new ArrayList<>();
	private List<FareOption> fareOption = new ArrayList<>();
	
}
