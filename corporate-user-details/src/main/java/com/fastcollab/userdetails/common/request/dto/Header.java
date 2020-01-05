package com.fastcollab.userdetails.common.request.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Header implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1429796816877249745L;
	
	private String host;
	 private String origin;
	 private String authorization;


	}