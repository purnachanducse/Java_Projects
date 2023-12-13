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
@Table(name = "tbl_gstin_details")
public class GstinDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730075089647732656L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gstin_req_id", length = 25)
	private BigInteger gstinReqId;

	@Column(name = "gstin")
	private String gstin;

	@Column(name = "app_id")
	private Integer appId;

	@Column(name = "entity_name")
	private String entityName;

	@Column(name = "created_date")
	private Date createdDate;

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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
