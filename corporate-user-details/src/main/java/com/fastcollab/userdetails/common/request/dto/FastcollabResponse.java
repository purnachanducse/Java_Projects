package com.fastcollab.userdetails.common.request.dto;

import com.fastcollab.userdetails.common.enums.FCHttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FastcollabResponse {

	private FCHttpStatus status;

	private String message;

	private Object payload;
	
	private int statusCode;

	private FastcollabResponse(){
	}

	public FastcollabResponse(Object payload,String message,FCHttpStatus status){
		this.payload =  payload;
		this.message = message;
		this.status = status;
		this.statusCode = status.getCode();
	}

	public FastcollabResponse(String message,FCHttpStatus status){
		this.message = message;
		this.status = status;
		this.statusCode = status.getCode();
	}

	public FastcollabResponse(Object payload,FCHttpStatus status){
		this.payload =  payload;
		this.status = status;
		this.statusCode = status.getCode();
	}
	
	public FCHttpStatus getStatus() {
		return status;
	}

	public void setStatus(FCHttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
