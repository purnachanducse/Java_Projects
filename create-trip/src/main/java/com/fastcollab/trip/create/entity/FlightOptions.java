package com.fastcollab.trip.create.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Flight_Options")
public class FlightOptions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Flight_Option_Id")
	private Long flightOptionId;
	@Column(name="Trip_Indicator")
	private Integer tripIndicator;
	@Column(name="Status_Id")
	private Long statusId;
	@Column(name="Fare_Type")
	private Integer fareType;
	@Column(name="Fare_BasisCode")
	private String fareBasisCode;
	@Column(name="Fare_Base_Class")
	private String fareBaseClass;
	@Column(name="Price")
	private Double price;
	@Column(name="Base_Fare")
	private Double baseFare;
	@Column(name="Tax_Fare")
	private Double taxFare;
	@Column(name="Management_Fee")
	private Double managementFee;
	@Column(name="Airline_Name")
	private String airlineName;
	@Column(name="Airline_Code")
	private String airlineCode;
	@Column(name="Flight_Number")
	private String flightNumber;
	@Column(name="Flight_Model_Name")
	private String flightModelName;
	@Column(name="Flight_Model_Number")
	private String flightModelNumber;
	@Column(name="Journey_Time")
	private Integer journeyTime;
	@Column(name="No_Of_Stops")
	private Integer noOfStops;
	@Column(name="Departure_Airport_Code")
	private String departureAirportCode;
	@Column(name="Departure_Date")
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
	
	//Relationship FlightOptions<--FlightRequests
	/*@ManyToOne
	@JoinColumn(name="Flight_Request_Id")
	private FlightRequests flightOptionsFlightRequests;*/
	
	@OneToMany(/*mappedBy="flightOptionsSegments",*/cascade=CascadeType.ALL)
	@JoinColumn(name="Flight_Option_Id")
	private List<FlightSegments> flightSegments;
	
	@OneToMany(/*mappedBy="flightOptionsPassanger",*/cascade=CascadeType.ALL)
	@JoinColumn(name="Flight_Option_Id")
	private List<FlightPassengers> flightPassengers;
	
	@OneToMany(/*mappedBy="flightOptionsSharedFlight",*/cascade=CascadeType.ALL)
	@JoinColumn(name="Flight_Option_Id")
	private List<SharedFlightOptions> sharedFlightOptions; 
	

}
