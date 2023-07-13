package com.ashu.organizationservice.mapper;

import com.ashu.organizationservice.dto.OrganizationDto;
import com.ashu.organizationservice.entity.Organization;

public class OrganizationMapper {
	
	public static OrganizationDto returnOrgDto(Organization org) {
		return new OrganizationDto(org.getId(), org.getOrganizationName(),
				org.getOrganizationDescription(),
				org.getOrganizationCode(), org.getCreatedDate());
	}
	
	public static Organization returnOrg(OrganizationDto dto) {
		return new Organization(dto.getId(), dto.getOrganizationName(), dto.getOrganizationDescription(),
				dto.getOrganizationCode(), dto.getCreatedDate());
	}

}
