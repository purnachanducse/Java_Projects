package com.fastcollab.trip.create.dto;

import com.fastcollab.trip.create.enums.FCHttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author FastCollab
 *
 */
@Setter
@Getter
public class FastcollabResponse {

	private FCHttpStatus status;

	private String message;

	private Object payload;

	private int statusCode;

	private FastcollabResponse() {
	}

	public FastcollabResponse(Object payload, String message, FCHttpStatus status) {
		this.payload = payload;
		this.message = message;
		this.status = status;
		this.statusCode = status.getCode();
	}

	public FastcollabResponse(String message, FCHttpStatus status) {
		this.message = message;
		this.status = status;
		this.statusCode = status.getCode();
	}

	public FastcollabResponse(Object payload, FCHttpStatus status) {
		this.payload = payload;
		this.status = status;
		this.statusCode = status.getCode();
	}
}
