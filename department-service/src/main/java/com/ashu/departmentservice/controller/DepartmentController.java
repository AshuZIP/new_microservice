package com.ashu.departmentservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.departmentservice.dto.DepartmentDTO;
import com.ashu.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/departments")
@CrossOrigin
public class DepartmentController {
	
	DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO depDto){
		return new ResponseEntity<>(departmentService.saveDepartment(depDto), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments(){
		return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<DepartmentDTO> getSingleDepartmentById(@PathVariable Long id){
		return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/byCode/{code}")
	public ResponseEntity<DepartmentDTO> getSingleDepartmentById(@PathVariable String code){
		return new ResponseEntity<>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
	}

}
