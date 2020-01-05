package com.fastcollab.search.city.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 
 * @author 10656321
 * Purpose :Entity for City table
 *
 */
@Entity
@Table(name = "City", schema = "EVA", catalog = "EVA")
@Getter
@Setter
@ToString
public class CityEntity {
    @Id
    @GeneratedValue
    @Column(name="CityID")
    private Integer cityId;

    @Column(name = "City_Code")
    private String cityCode;
    
    @Column(name = "City_Name")
    private String cityName;
    
    @Column(name="Top_Rank")
    private Integer topCityRank;
    
    @Column(name="Active")
    private Integer active;
    
    /*Mapping between City & Airport */
    /*@OneToMany(
	        mappedBy = "city",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<AirportEntity> airportDetails; */
    
    /*unidirectional city & Country*/
    @ManyToOne
    @JoinColumn(name = "CountryID")
    private CountryEntity country;
    
    
	
}
