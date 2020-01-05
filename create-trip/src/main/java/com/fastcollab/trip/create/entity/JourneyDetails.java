package com.fastcollab.trip.create.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Journey_Details")
public class JourneyDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Journey_Id")
	private Long journeyId;
	@Column(name="From_City_Id")
	private Long fromCityId;
	@Column(name="To_City_Id")
	private Long toCityId;
	@Column(name="Departure_Date")
	private Date departureDate;
	@Column(name="Return_Date")
	private Date returnDate;
//	@ManyToOne
//	@JoinColumn(name="Flight_Request_Id")
//	private FlightRequests flightRequests;

}
