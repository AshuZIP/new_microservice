package com.ashu.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.organizationservice.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>{
	
	Organization findByOrganizationName(String organizationName);
	Organization findByOrganizationCode(String organizationCode);
}
