/**
 * 
 */
package com.in28minutes.restfullwebservices.exception;

import java.util.Date;

import lombok.Data;

/**
 * @author 10661300
 *
 */
@Data
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
}
