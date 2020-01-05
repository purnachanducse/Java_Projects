package com.fastcollab.trip.create.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Shared_Flight_Options")
public class SharedFlightOptions {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Shared_Flight_Options_Id")
	private Long sharedFlightOptionId;
	
	//Relationship SharedFlightOptions<---FlightOptions
//	@ManyToOne
//	@JoinColumn(name="Flight_Option_Id")
//	private FlightOptions flightOptionsSharedFlight;
}
