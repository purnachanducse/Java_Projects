package com.fastcollab.trip.create.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Fare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7479318035285388333L;

	private String currency;
	private double basePrice;//Flight_options
	private double tax;//Flight_options
	private double otherTaxes;
	private Double ticketPrice;//Flight_options.price & Trip_master.Trip_cost & Flight_Requests.Price
	private double commission;
}
