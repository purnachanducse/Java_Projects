package com.fastcollab.trip.create.dto;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripMaster {
	private Long tripId;
	private String guid;
	private String tripName;
	private Long userId;
	private String tripCost;
	private Integer statusId;
	private boolean isEmailRequest;
	private Long createdBy;
	private Date createdDate;
	private Long updatedBy;
	private Date updatedDate;
	private Long  assignedAgentId;
	private FlightRequests flightRequests;
}
