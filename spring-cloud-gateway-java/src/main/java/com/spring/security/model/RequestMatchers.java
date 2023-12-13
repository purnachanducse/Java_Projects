/**
 * 
 */
package com.spring.security.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "tbl_request_matchers")
public class RequestMatchers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6238174491734472445L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "req_matcher_id", length = 25)
	private BigInteger reqMatcherId;

	@Column(name = "context_path")
	private String contextPath;

	@Column(name = "endpoint_main_path")
	private String endpointMainPath;

	@Column(name = "endpoint_sub_path")
	private String endpointSubPath;

	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "client_id")
	private String clientId;
	
	
	@Column(name = "is_include")
	private String isInclude;

	public BigInteger getReqMatcherId() {
		return reqMatcherId;
	}

	public void setReqMatcherId(BigInteger reqMatcherId) {
		this.reqMatcherId = reqMatcherId;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getEndpointMainPath() {
		return endpointMainPath;
	}

	public void setEndpointMainPath(String endpointMainPath) {
		this.endpointMainPath = endpointMainPath;
	}

	public String getEndpointSubPath() {
		return endpointSubPath;
	}

	public void setEndpointSubPath(String endpointSubPath) {
		this.endpointSubPath = endpointSubPath;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getIsInclude() {
		return isInclude;
	}

	public void setIsInclude(String isInclude) {
		this.isInclude = isInclude;
	}
	
	

}
