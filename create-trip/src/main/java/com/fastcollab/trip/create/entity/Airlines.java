package com.fastcollab.trip.create.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Airlines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AirlineID")
	private Integer airlineId;
	@Column(name = "Airline_Code")
	private String airlineCode;
	@Column(name = "Airline_Name")
	private String airlineName;
	@Column(name = "Min_Hrs_Tracking")
	private Integer minHrsTracking;
	@Column(name = "Active")
	private Integer status;
	
	
}
