package com.ashu.departmentservice.mapper;

import com.ashu.departmentservice.dto.DepartmentDTO;
import com.ashu.departmentservice.entity.Department;

public class DepartmentMapper {

	public static DepartmentDTO returnDepartmentDTO(Department department) {
		DepartmentDTO dto = new DepartmentDTO(department.getId(), department.getDepartmentName(),
				department.getDepartmentDescription(), department.getDepartmentCode());
		return dto;
	}
	
	public static Department returnDepartment(DepartmentDTO dto) {
		return new Department(dto.getId(),dto.getDepartmentName(), dto.getDepartmentDescription(), dto.getDepartmentCode());
	}
}
