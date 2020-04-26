**
 * 
 */
package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.batch.dto.EmployeeDTO;
import com.batch.model.Employee;

/**
 * @author 10661300
 *
 */
@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee>{

	@Override
	public Employee process(EmployeeDTO employeeDTO) throws Exception {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		  employee.setEmployeeId(employeeDTO.getEmployeeId());
	        employee.setFirstName(employeeDTO.getFirstName());
	        employee.setLastName(employeeDTO.getLastName());
	        employee.setEmail(employeeDTO.getEmail());
	        employee.setAge(employeeDTO.getAge());
	        System.out.println("inside processor " + employee.toString());
	        return employee;
		return employee;
	}

}
