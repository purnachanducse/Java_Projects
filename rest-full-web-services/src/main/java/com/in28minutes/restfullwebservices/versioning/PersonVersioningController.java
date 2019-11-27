/**
 * 
 */
package com.in28minutes.restfullwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10661300
 *
 */
@RestController
public class PersonVersioningController {
	
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Purna");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Purna Chandu", "Sapparapu"));
	}
	
	@GetMapping(value = "/person/param",params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Purna");
		
	}
	
	@GetMapping(value = "/person/param",params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Purna Chandu", "Sapparapu"));
	}
	
	@GetMapping(value = "/person/headers",headers = "X-API-VERSION=1")
	public PersonV1 headersV1() {
		return new PersonV1("Purna");
		
	}
	
	@GetMapping(value = "/person/headers",headers = "X-API-VERSION=2")
	public PersonV2 headersV1V2() {
		return new PersonV2(new Name("Purna Chandu", "Sapparapu"));
	}
	
	@GetMapping(value = "/person/produces",produces =  "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Purna");
		
	}
	
	@GetMapping(value = "/person/produces",produces =  "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Purna Chandu", "Sapparapu"));
	}
}
