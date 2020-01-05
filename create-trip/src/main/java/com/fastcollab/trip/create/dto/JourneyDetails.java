package com.fastcollab.trip.create.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JourneyDetails implements Serializable{
	private Long journeyId;
	private Long fromCityId;
	private Long toCityId;
	private Date departureDate;
	private Date returnDate;
	private FlightRequests flightRequests;
}
