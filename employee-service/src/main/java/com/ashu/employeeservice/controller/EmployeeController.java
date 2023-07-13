package com.ashu.employeeservice.controller;

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

import com.ashu.employeeservice.dto.ApiResponseDto;
import com.ashu.employeeservice.dto.EmployeeDto;
import com.ashu.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/employee")
@AllArgsConstructor
@CrossOrigin
public class EmployeeController {
	
	private EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto empDto){
		return new ResponseEntity<>(empService.saveEmployee(empDto), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		return new ResponseEntity<>(empService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping(value="/get/{id}")
	public ResponseEntity<ApiResponseDto> getAllEmployees(@PathVariable Long id){
		return new ResponseEntity<>(empService.getSingleEmployeeById(id), HttpStatus.OK);
	}
}
