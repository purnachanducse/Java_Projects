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
@Table(name="Flight_Requests")
public class FlightRequests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Flight_Request_Id")
	private Long flightRequestId;
	@Column(name="Guid")
	private String guid;
	@Column(name="Status_Id")
	private Long statusId;
	@Column(name="Travel_Type")
	private Integer travelType;
	@Column(name="Travel_Mode")
	private Integer travelMode;
	@Column(name="Price")
	private Double price;
	@Column(name="Cabin_Class")
	private Integer cabinClass;
	@Column(name="Adult_Count")
	private Integer adultCount;
	@Column(name="Child_Count")
	private Integer childCount;
	@Column(name="Infant_Count")
	private Integer infantCount;
	@Column(name="From_City_Name")
	private String fromCityName;
	@Column(name="To_City_Name")
	private String toCityName;
	@Column(name="Departure_Date")
	private Date departureDate;
	@Column(name="Return_Date")
	private Date returnDate;
	@Column(name="Passengers")
	private String passengers;
	@Column(name="Onward_PNR")
	private String onwardPNR;
	@Column(name="Return_PNR")
	private String returnPNR;
	//Relationship TripMaster->FlightRequest
//	@ManyToOne
//	@JoinColumn(name="Trip_Id")
//	private TripMaster tripMaster;
	
	//RelationShip  FlightRequest-->JourneyDetails
	@OneToMany(/*mappedBy="flightRequests", */cascade = CascadeType.ALL)
	@JoinColumn(name="Flight_Request_Id")
	private List<JourneyDetails> journeyDetails;
	
	//RelationShip FlightRequest-->FlightOptions
	@OneToMany(/*mappedBy="flightOptionsFlightRequests",*/cascade = CascadeType.ALL)
	@JoinColumn(name="Flight_Request_Id")
	private List<FlightOptions> flightOptions;
	
	
	
	

}
