package com.fastcollab.trip.create.entity;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Trip_Master")
@Getter
@Setter
public class TripMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Trip_Id")
	private Long tripId;
	@Column(name="Guid",unique=true)
//	@GeneratedValue(generator="uuid")
//	@GenericGenerator(name="uuid" ,strategy="uuid2")
	//@org.hibernate.annotations.Generated(GenerationTime.INSERT)
	private String guid;
	@Column(name="Trip_Name")
	private String tripName;
	@Column(name="User_Id")
	private Long userId;
	@Column(name="Trip_Cost")
	private String tripCost;
	@Column(name="Status_Id")
	private Integer statusId;
	@Column(name="Is_Email_Request")
	private boolean isEmailRequest;
	@Column(name="Created_By")
	private Long createdBy;
	@Column(name="Created_Date")
	private Date createdDate;
	@Column(name="Updated_By")
	private Long updatedBy;
	@Column(name="Updated_Date")
	private Date updatedDate;
	@Column(name="Assigned_Agent_Id")
	private Long assignedAgentId;
	
	@OneToMany(/*mappedBy = "tripMaster",*/ cascade = CascadeType.ALL)//fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="Trip_Id")
	private List<FlightRequests> flightRequests;
}
