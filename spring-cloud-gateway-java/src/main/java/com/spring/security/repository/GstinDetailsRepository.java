/**
 * 
 */
package com.spring.security.repository;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.GstinDetails;

/**
 * 
 */
@Repository
@Transactional
public interface GstinDetailsRepository extends CrudRepository<GstinDetails, BigInteger> {

	public GstinDetails findByGstinReqId(BigInteger gstinReqId);
	
	public GstinDetails findByAppId(Integer appid);

	public void deleteByGstinReqId(BigInteger gstinReqId);

}
