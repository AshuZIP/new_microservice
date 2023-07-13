/**
 * 
 */
package com.ashu.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.departmentservice.entity.Department;

/**
 * @author Ashutosh.Ranjan
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDepartmentCode(String departmentCode);

}
