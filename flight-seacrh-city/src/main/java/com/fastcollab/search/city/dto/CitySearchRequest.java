package com.fastcollab.search.city.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 10656321
 *	Purpose :RequestPayload model
 */
@Getter
@Setter
public class CitySearchRequest {
	private String corporateId;
	private String searchText;

}
