package com.ashu.organizationservice.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashu.organizationservice.dto.OrganizationDto;
import com.ashu.organizationservice.entity.Organization;
import com.ashu.organizationservice.mapper.OrganizationMapper;
import com.ashu.organizationservice.repository.OrganizationRepository;
import com.ashu.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{
	
	private OrganizationRepository repo;

	@Override
	public List<OrganizationDto> returnAllOrganizations() {
		List<Organization> lis = repo.findAll();
		List<OrganizationDto> dto = new ArrayList<>();
		for(Organization org:lis) {
			dto.add(OrganizationMapper.returnOrgDto(org));
		}
		return dto;
	}

	@Override
	public OrganizationDto returnOrgById(Long id) {
		Organization org = repo.getById(id);
		return OrganizationMapper.returnOrgDto(org);
	}

	@Override
	public OrganizationDto returnOrgByName(String name) {
		Organization org = repo.findByOrganizationName(name);
		return OrganizationMapper.returnOrgDto(org);
	}

	@Override
	public OrganizationDto saveOrganization(OrganizationDto dto) {
		Organization org = repo.save(OrganizationMapper.returnOrg(dto));
		return OrganizationMapper.returnOrgDto(org);
	}

	@Override
	public OrganizationDto returnOrgByCode(String code) {
		return OrganizationMapper.returnOrgDto(repo.findByOrganizationCode(code));
	}

}
