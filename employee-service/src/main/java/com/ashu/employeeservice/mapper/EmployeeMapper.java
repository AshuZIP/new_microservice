package com.ashu.employeeservice.mapper;

import com.ashu.employeeservice.dto.EmployeeDto;
import com.ashu.employeeservice.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto returnEmployeeDto(Employee emp) {
		return new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartmentCode(), emp.getOrganizationCode());
	}
	
	public static Employee returnEmployee(EmployeeDto dto) {
		return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getDepartmentCode(), dto.getOrganizationCode(), dto.getEmail());
	}
}
