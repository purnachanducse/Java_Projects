/**
 * Copyright (c) 1994, 2025, SPAAKs and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.paging.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.paging.entities.Employee;

/**
 * @author 10661300
 *
 */
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
