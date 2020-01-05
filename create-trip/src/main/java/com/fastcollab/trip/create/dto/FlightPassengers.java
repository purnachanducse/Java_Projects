package com.fastcollab.trip.create.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightPassengers  implements Serializable{
	private Long passengerId;
	private Long flightOptionId;
	private Long userId;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer paxType;
	private Integer gender;
	private Long userType;
	private Date dobTime;
	private String passportNumber;
	private Date passportExpiryDate;
	private String ticketNumber;
	private String nationality;
	private String passportIssuedCountry;
}
