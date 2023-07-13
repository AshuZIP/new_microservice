package com.ashu.organizationservice.service;

import java.util.List;

import com.ashu.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	
	List<OrganizationDto> returnAllOrganizations();
	
	OrganizationDto returnOrgById(Long id);
	
	OrganizationDto returnOrgByName(String name);
	
	OrganizationDto saveOrganization(OrganizationDto dto);
	
	OrganizationDto returnOrgByCode(String code);
}
