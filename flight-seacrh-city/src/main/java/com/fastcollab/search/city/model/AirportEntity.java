package com.fastcollab.search.city.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 
 * @author 10656321
 * Purpose :Entity for Airport table
 *
 */
@Entity
@Table(name="Airports")
@Getter
@Setter
@ToString
@NamedStoredProcedureQuery(name = "citiesDetails",
procedureName = "getCities",
	parameters={@StoredProcedureParameter(mode = ParameterMode.IN, name = "parSearch", type = String.class)},
resultClasses = AirportEntity.class)
public class AirportEntity {
	@Id
	private Integer airportId;
	@Column(name="Airport_Code")
	private String airportCode;
	@Column(name="Airport_Name")
	private String airportName;
	private boolean rank;
	private boolean isTopRank;
	private boolean active;
	@ManyToOne
    @JoinColumn(name = "City_ID")
	private CityEntity city;
	@ManyToOne
    @JoinColumn(name = "CountryID")
	private CountryEntity country;
}
