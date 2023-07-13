/**
 * 
 */
package com.ashu.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashu.employeeservice.dto.DepartmentDto;
import com.ashu.employeeservice.dto.OrganizationDto;

/**
 * @author Ashutosh.Ranjan
 *
 */

@FeignClient(name = "department-service")//(url="http://localhost:8080/", value = "Department-Service")
public interface OpenFeignAPICient {
	
	@GetMapping(value = "api/departments/get/byCode/{code}")
	DepartmentDto getSingleDepartmentById(@PathVariable String code);

}
