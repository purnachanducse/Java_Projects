/**
 * Copyright (c) 1994, 2025, SPAAKs and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paging.entities.Employee;
import com.paging.service.EmployeeService;

/**
 * @author 10661300
 *
 */
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "firstName") String sortBy){
		List<Employee> listOfEmps= employeeService.getAllEmployees(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<Employee>>(listOfEmps,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}
}
