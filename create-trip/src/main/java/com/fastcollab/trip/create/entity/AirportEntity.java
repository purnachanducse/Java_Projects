package com.fastcollab.trip.create.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Data;

/***
 * 
 * Purpose :Entity for Airport table. Integrated stored procedure call
 * 
 * @author Kaleshwari Hallikerimath
 * @parm List of AirportEntity
 * @param <parSearch>
 *            SPoc input variable
 * @version 1.0
 * @since 03-10-2019
 * 
 */
@Entity
@Table(name = "Airports")
@Data
public class AirportEntity {
	@Id
	private Integer airportId;
	@Column(name = "Airport_Code")
	private String airportCode;
	@Column(name = "Airport_Name")
	private String airportName;
	private boolean rank;
	private boolean isTopRank;
	private boolean active;
	
}
