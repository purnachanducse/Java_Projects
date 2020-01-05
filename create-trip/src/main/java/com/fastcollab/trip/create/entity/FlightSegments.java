package com.fastcollab.trip.create.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Flight_Segments")
public class FlightSegments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Segment_Id")
	private Long segmentId;
	@Column(name="Departure_Airport_Code")
	private String departureAirportCode;
	@Column(name="Departure_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDate;
	@Column(name="Departure_Airport_Name")
	private String departureAirportName;
	@Column(name="Departure_Terminal")
	private String departureTerminal;
	@Column(name="Arrival_Airport_Code")
	private String arrivalAirportCode;
	@Column(name="Arrival_Date")
	private Date arrivalDate;
	@Column(name="Arrival_Airport_Name")
	private String arrivalAirportName;
	@Column(name="Arrival_Terminal")
	private String arrivalTerminal;
	@Column(name="Booking_Class")
	private String bookingClass;
	@Column(name="Airline_Name")
	private String airlineName;
	@Column(name="Airline_Code")
	private String airlineCode;
	@Column(name="Flight_Number")
	private String flightNumber;
	@Column(name="Journey_Time")
	private Integer journeyTime;
	@Column(name="Layover_Duration")
	private Integer layoverDuration;
//	@ManyToOne
//	@JoinColumn(name="Flight_Option_Id")
//	private FlightOptions flightOptionsSegments;
	
	

}
