package com.fastcollab.trip.create.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FlightRequests {

	private Long flightRequestId;
	private String guid;
	private Integer statusId;
	private Integer travelType;
	private Integer travelMode;
	private Double price;
	private Integer cabinClass;
	private Integer adultCount;
	private Integer childCount;
	private Integer infantCount;
	private String fromCityName;
	private String toCityName;
	private Date departureDate;
	private Date returnDate;
	private String passengers;
	private String onwardPNR;
	private String returnPNR;
	//Relationship TripMaster->FlightRequest
	@OneToOne
	@JoinColumn(name="tripId")
	private TripMaster tripMaster;
	
	//RelationShip  FlightRequest-->JourneyDetails
	@OneToOne(mappedBy="flightRequests")
	private JourneyDetails journeyDetails;
	
	//RelationShip FlightRequest-->FlightOptions
	@OneToOne(mappedBy="flightOptionsFlightRequests")
	private FlightOptions flightOptions;
	
	
	
	

}
