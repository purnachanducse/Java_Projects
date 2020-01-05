package com.fastcollab.search.city.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * 
 * @author 10656321
 * Purpose : Response payload (Stores City Details
 * 			
 * 
 *
 */
@Getter
@Setter
@ToString
public class CiityDetailsDTO implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String cityCode;
	    
	    private String cityName;
	    
	    private String countryCode;
	    
	    private String countryName;
	    
	    private String airportCode;
	    
	    private String airportName;

		}
