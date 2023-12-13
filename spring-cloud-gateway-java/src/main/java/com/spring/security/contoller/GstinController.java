/**
 * 
 */
package com.spring.security.contoller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.GstinDetails;
import com.spring.security.payloads.GstinReqPayload;
import com.spring.security.repository.GstinDetailsRepository;
import com.spring.security.service.GstinDetailsService;

/**
 * 
 */
@RestController
@RequestMapping("/gstin-details/")
public class GstinController {
	
	@Autowired
	GstinDetailsService gstinDetailsService;
	
	//@Autowired
	GstinDetailsRepository gstinDetailsRepository;
	
	@GetMapping("gstin/")
	public ResponseEntity<?> getGstinDetailsByGstinReqId(@RequestParam("gstinReqId") BigInteger gstinReqId) {//@RequestBody GstinReqPayload gstinReqPayload
		GstinDetails gstinDetails = gstinDetailsRepository.findByGstinReqId(gstinReqId);
		return new ResponseEntity<>(gstinDetails, HttpStatus.OK);
	}
	
	@PostMapping("gstin/appId/")
	public ResponseEntity<?> getGstinDetailsByGstinReqId(@RequestBody GstinReqPayload gstinReqPayload) {
		GstinDetails gstinDetails = gstinDetailsRepository.findByGstinReqId(gstinReqPayload.getGstinReqId());
		return new ResponseEntity<>(gstinDetails, HttpStatus.OK);
	}

}
