package com.fastcollab.trip.create.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightSegments {
	private Long segmentId;
	private String departureAirportCode;
	private Date departureDate;
	private String departureAirportName;
	private String departureTerminal;
	private String arrivalAirportCode;
	private Date arrivalDate;
	private String arrivalAirportName;
	private String arrivalTerminal;
	private String bookingClass;
	private String airlineName;
	private String airlineCode;
	private String flightNumber;
	private Integer journeyTime;
	private Integer layoverDuration;
	private FlightOptions flightOptionsSegments;
	
	

}
