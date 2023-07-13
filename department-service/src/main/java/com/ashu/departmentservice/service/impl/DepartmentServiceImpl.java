package com.ashu.departmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashu.departmentservice.dto.DepartmentDTO;
import com.ashu.departmentservice.entity.Department;
import com.ashu.departmentservice.mapper.DepartmentMapper;
import com.ashu.departmentservice.repository.DepartmentRepository;
import com.ashu.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepo;
	
	//We will perform Constructor based DI as it is preferred way for doing the same
//	public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
//		super();
//		this.departmentRepo = departmentRepo;
//	}
	

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDto) {
		
		//Convert department dto object to department jpa entity
		Department dp = DepartmentMapper.returnDepartment(departmentDto);
		//new Department(departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode());
		
		Department savedDepartment = departmentRepo.save(dp);
		return DepartmentMapper.returnDepartmentDTO(savedDepartment);
//		return new DepartmentDTO(savedDepartment.getId(), savedDepartment.getDepartmentName(),
//				savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode());
	}

	@Override
	public List<DepartmentDTO> getAllDepartments() {
		List<Department> deps = departmentRepo.findAll();
		List<DepartmentDTO> depsDto = new ArrayList<>();
		for(Department dt:deps) {
			depsDto.add(DepartmentMapper.returnDepartmentDTO(dt));
		}
		
		return depsDto;
	}

	@Override
	public DepartmentDTO getDepartmentById(Long id) {
		Department dp = departmentRepo.getById(id);
		return DepartmentMapper.returnDepartmentDTO(dp);
		//return new DepartmentDTO(dp.getId(), dp.getDepartmentName(), dp.getDepartmentDescription(), dp.getDepartmentCode());
	}

	@Override
	public DepartmentDTO getDepartmentByCode(String departmentCode) {
		Department dept = departmentRepo.findByDepartmentCode(departmentCode);
		return DepartmentMapper.returnDepartmentDTO(dept);
		//return new DepartmentDTO(dept.getId(), dept.getDepartmentName(), dept.getDepartmentDescription(), dept.getDepartmentDescription());
	}

}
