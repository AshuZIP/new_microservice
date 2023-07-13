package com.ashu.employeeservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashu.employeeservice.dto.ApiResponseDto;
import com.ashu.employeeservice.dto.DepartmentDto;
import com.ashu.employeeservice.dto.EmployeeDto;
import com.ashu.employeeservice.dto.OrganizationDto;
import com.ashu.employeeservice.entity.Employee;
import com.ashu.employeeservice.mapper.EmployeeMapper;
import com.ashu.employeeservice.repository.EmployeeRepository;
import com.ashu.employeeservice.service.EmployeeService;
import com.ashu.employeeservice.service.OpenFeignAPICient;
import com.ashu.employeeservice.service.OpenFeignOrgClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository eRepo;
	
	//private RestTemplate restTemplate;
	
	//private WebClient webClient;
	
	private OpenFeignAPICient openFeignAPIClient;
	
	private OpenFeignOrgClient openFeignClientOrg;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//		Employee emp = eRepo.save(new Employee(employeeDto.getId(), employeeDto.getFirstName(),
//				employeeDto.getLastName(), employeeDto.getDepartmentCode(), employeeDto.getEmail()));
		Employee emp = eRepo.save(EmployeeMapper.returnEmployee(employeeDto));
		return EmployeeMapper.returnEmployeeDto(emp);
		//return new EmployeeDto(emp.getId(), emp.getFirstName(),emp.getLastName(),emp.getEmail(), emp.getDepartmentCode());
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> empLists = eRepo.findAll();
		List<EmployeeDto> e_lists = new ArrayList<>();
		for(Employee emp:empLists) {
			e_lists.add(EmployeeMapper.returnEmployeeDto(emp));
			//e_lists.add(new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartmentCode()));
		}
		return e_lists;
		
	}

	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto getSingleEmployeeById(Long id) {
		
		String dc = "ITAS001";
		String oc = "BGDING1";
		List<Employee> empp = eRepo.findAll();
		Employee emp = null;
		for(Employee em:empp) {
			if(em.getId()==(id)) {
				dc = em.getDepartmentCode();
				oc = em.getOrganizationCode();
				emp=em;
				break;
			}
		}
		
//		DepartmentDto forEntity = webClient.get().uri("http://localhost:8080/api/departments/get/byCode/"+dc)
//		.retrieve()
//		.bodyToMono(DepartmentDto.class)
//		.block();
		
		DepartmentDto forEntity = openFeignAPIClient.getSingleDepartmentById(dc);
		
		//ResponseEntity<DepartmentDto> forEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/get/byCode/"+dc, DepartmentDto.class);
		
//		DepartmentDto departmentDto = forEntity.getBody();
		
		OrganizationDto dto = openFeignClientOrg.getByCode(oc);
		
		EmployeeDto empDto = EmployeeMapper.returnEmployeeDto(emp);//new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartmentCode());
		
		ApiResponseDto dtoR = new ApiResponseDto(empDto, forEntity, dto);
		
		return dtoR;
	}
	
	public ApiResponseDto getDefaultDepartment(Long id, Exception exception) {
		DepartmentDto dto = new DepartmentDto();
		EmployeeDto edto = new EmployeeDto();
		OrganizationDto oDto = new OrganizationDto();
		return new ApiResponseDto(edto, dto, oDto);
	}

}
