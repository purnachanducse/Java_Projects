/**
 * 
 */
package com.spring.security.payloads;

import java.io.Serializable;
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GstinReqPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6422556005014867806L;

	private BigInteger gstinReqId;
	private String gstin;
	private Integer appId;

	public BigInteger getGstinReqId() {
		return gstinReqId;
	}

	public void setGstinReqId(BigInteger gstinReqId) {
		this.gstinReqId = gstinReqId;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

}
