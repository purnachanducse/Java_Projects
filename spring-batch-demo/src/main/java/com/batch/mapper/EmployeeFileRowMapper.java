/**
 * 
 */
package com.batch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.batch.dto.EmployeeDTO;

/**
 * @author 10661300
 *
 */
public class EmployeeFileRowMapper implements FieldSetMapper<EmployeeDTO>{

	@Override
	public EmployeeDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		EmployeeDTO dto = new EmployeeDTO();
		
		return null;
	}

}
