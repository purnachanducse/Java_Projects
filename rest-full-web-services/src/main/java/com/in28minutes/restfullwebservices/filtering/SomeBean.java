/**
 * 
 */
package com.in28minutes.restfullwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 10661300
 *
 */
@Data
@NoArgsConstructor
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	@JsonIgnore
	private String someValue1;
	
	private String someValue2;
	private String someValue3;
	/**
	 * @param someValue1
	 * @param someValue2
	 * @param someValue3
	 */
	public SomeBean(String someValue1, String someValue2, String someValue3) {
		super();
		this.someValue1 = someValue1;
		this.someValue2 = someValue2;
		this.someValue3 = someValue3;
	}

}
