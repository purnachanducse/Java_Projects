package com.fastcollab.trip.create.dto;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FlightOptions {
	private Long flightOptionId;
	private Long flightRequestId;
	private Integer tripIndicator;
	private Long statusId;
	private Integer fareType;
	private String fareBasisCode;
	private String fareBaseClass;
	private Double price;
	private Double baseFare;
	private Double taxFare;
	private Float managementFee;
	private String airlineName;
	private String airlineCode;
	private String flightNumber;
	private String flightModelName;
	private String flightModelNumber;
	private Integer journeyTime;
	private Integer noOfStops;
	private String departureAirportCode;
	private Date departureDate;
	private String departureAirportName;
	private String departureTerminal;
	private String arrivalAirportCode;
	private Date arrivalDate;
	private String arrivalAirportName;
	private String arrivalTerminal;
	
}