package com.fastcollab.trip.create.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Flight_Passengers")
public class FlightPassengers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Passenger_Id")
	private Long passengerId;
	@Column(name="User_Id")
	private Long userId;
	@Column(name="Title")
	private String title;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Middle_Name")
	private String middleName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="Pax_Type")
	private Integer paxType;
	@Column(name="Gender")
	private Integer gender;
	@Column(name="User_Type")
	private Long userType;
	@Column(name="DOB")
	private Date dobTime;
	@Column(name="Passport_Number")
	private String passportNumber;
	@Column(name="Passport_Expiry_Date")
	private Date passportExpiryDate;
	@Column(name="Ticket_Number")
	private String ticketNumber;
	@Column(name="Nationality")
	private String nationality;
	@Column(name="Passport_Issued_Country")
	private String passportIssuedCountry;
//	@ManyToOne
//	@JoinColumn(name="Flight_Option_Id")
//	private FlightOptions flightOptionsPassanger;
}
