/**
 * 
 */
package com.lnt.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sapparapu
 *
 */
@RestController
public class InternationalizationController {

	@Autowired
	public MessageSource messageSource;
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		
		return messageSource.getMessage("good.morning.message", null ,locale);
	}
	
//	@GetMapping(path = "/hello-world-internationalized")
//	public String helloWorldInternationalized() {
//		return messageSource.getMessage("good.morning.message", null, 
//									LocaleContextHolder.getLocale());
//	}
}
