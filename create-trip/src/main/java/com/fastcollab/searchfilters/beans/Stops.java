/**
 * 
 */
package com.fastcollab.searchfilters.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 10660880
 *
 */
@Data
public class Stops {
	
	private String stopType;
	private Integer count;
	private Double minPrice;
}
