package com.ashu.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashu.employeeservice.dto.OrganizationDto;

@FeignClient(name = "organization-service")
public interface OpenFeignOrgClient {
	
	@GetMapping("api/organization/get/byCode/{code}")
	OrganizationDto getByCode(@PathVariable String code);

}
