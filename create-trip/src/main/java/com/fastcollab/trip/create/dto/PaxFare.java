package com.fastcollab.trip.create.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PaxFare implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 15649315434788904L;
	
	private PaxType paxType;//P.Type
	private Integer paxCount;// `Infant_Count or `Adult_Count 0r `Child_Count
	private Double baseFare;
	private Double taxFare;
	private String paxTypeKeys;
	private Double yqTax;
	private Double txnFeeOfrd;
	private Double txnFeePub;
}
