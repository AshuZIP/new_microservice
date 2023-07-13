package com.ashu.departmentservice.service;

import java.util.List;

import com.ashu.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
	
	DepartmentDTO saveDepartment(DepartmentDTO departmentDto);
	
	List<DepartmentDTO> getAllDepartments();
	
	DepartmentDTO getDepartmentById(Long id);
	
	DepartmentDTO getDepartmentByCode(String departmentCode);

}
