/**
 * 
 */
package com.boot.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 10661300
 *
 */
@Controller("error")
public class ErrorController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest request,Exception exception) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception",exception.getStackTrace());
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("error");
		return null;
		
	}
}
