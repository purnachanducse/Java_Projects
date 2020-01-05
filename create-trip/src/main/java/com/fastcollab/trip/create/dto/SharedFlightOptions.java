package com.fastcollab.trip.create.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SharedFlightOptions {
	private Long sharedFlightOptionId;
	private FlightOptions flightOptionsSharedFlight;
}
