package com.ashu.employeeservice.service;

import java.util.List;

import com.ashu.employeeservice.dto.ApiResponseDto;
import com.ashu.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	List<EmployeeDto> getAllEmployees();
	
	ApiResponseDto getSingleEmployeeById(Long id);

}
