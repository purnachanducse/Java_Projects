/**
 * Copyright (c) 1994, 2025, SPAAKs and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.paging.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.paging.dao.EmployeeRepository;
import com.paging.entities.Employee;

/**
 * @author 10661300
 *
 */
@Service
@Transactional(value = TxType.REQUIRED)
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = (Pageable) PageRequest.of(pageNo, pageSize, org.springframework.data.domain.Sort.by(sortBy));
		Page<Employee> pagedResult = (Page<Employee>) employeeRepository
				.findAll(paging);
		
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}
}
