package com.ashu.organizationservice.controller;

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

import com.ashu.organizationservice.dto.OrganizationDto;
import com.ashu.organizationservice.service.serviceimpl.OrganizationServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/organization")
@AllArgsConstructor
@CrossOrigin
public class OrganizationController {
	
	private OrganizationServiceImpl service;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
		return new ResponseEntity<>(service.saveOrganization(organizationDto), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<OrganizationDto>> findAll(){
		return new ResponseEntity<>(service.returnAllOrganizations(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<OrganizationDto> getById(@PathVariable Long id){
		return new ResponseEntity<>(service.returnOrgById(id), HttpStatus.OK);
	}
	
	@GetMapping("/get/byName/{name}")
	public ResponseEntity<OrganizationDto> getById(@PathVariable String name){
		return new ResponseEntity<>(service.returnOrgByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/get/byCode/{code}")
	public ResponseEntity<OrganizationDto> getByCode(@PathVariable String code){
		return new ResponseEntity<>(service.returnOrgByCode(code), HttpStatus.OK);
	}
}
