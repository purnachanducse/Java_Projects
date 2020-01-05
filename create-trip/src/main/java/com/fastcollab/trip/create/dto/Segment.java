package com.fastcollab.trip.create.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Segment implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 5014518970209097443L;

	private int tripIndex;
	private int segmentIndex;
	private String airline;     
	private String flightNumber;
	private String departureAirportCode;//Flight_Segments.Departure_Airport_Code
	private String departureDateTime;//Departure_Date
	private String departureTerminal;//Departure_Terminal
	private String arrivalAirportCode;//Arrival_Airport_Code(Get Name)
	private String arrivalDateTime;//Arrival_Date
	private String arrivalTerminal;//Arrival_Terminal
	private String bookingClass;//Booking_Class
	private Long journeyTimeInMinutes;//Journey_Time
	private String baggage;
	private String cabinBaggage;
	private String airCraft;
	private String fareBasis;
	private Integer noOfSeatsAvailability;
	private long layoverDurationInMinutes;//Layover_Duration
	private String segmentFareKey;
	private String segmentFareValue;
	private String tokenKey;
	private String tokenValue;
	private String segmentTokenBase64;

}
