/**
 * 
 */
package com.fastcollab.trip.create.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10656321
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="City")
public class CityEntity implements Serializable{

	@Id
	@Column(name="CityID")
	private String cityID;
	@Column(name="City_Code")
	private String cityCode;
	@Column(name="City_Name")
	private String cityName;
	@Column(name="CountryID")
	private Integer countryID;
	@Column(name="Active")
	private Integer Active;
	@Column(name = "Top_Rank")
	private Integer topRank;

}
