/**
 * 
 */
package com.in28minutes.restfullwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author 10661300
 *
 */
@RestController
public class FilteringController {

//	@GetMapping("/{filter}")
//	public SomeBean someBean() {
//		return new SomeBean("value1","value2","value3");
//	}
	
	@GetMapping("/filters")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("field1", "field2", "field3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/list")
	public List<SomeBean> someBeansRetrieval(){
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value21","value22","value23"));
	}
}
