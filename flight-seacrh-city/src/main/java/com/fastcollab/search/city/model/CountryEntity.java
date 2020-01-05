package com.fastcollab.search.city.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 
 * @author 10656321
 * Purpose :Entity for Country table
 *
 */
@Entity
@Table(name="Country")
@Setter
@Getter
@ToString
public class CountryEntity {
	@Id
	@GeneratedValue
	private Integer countryId;
	@Column(name="Country_Code")
	private String countryCode;
	@Column(name="Country_Name")
	private String countryName;
	private Integer active;
	
	/*Mapping between Country & City */
//	 @OneToMany(
//		        mappedBy = "country",
//		        cascade = CascadeType.ALL,
//		        orphanRemoval = true
//		    )
	//private List<CityEntity> cities; 

}
