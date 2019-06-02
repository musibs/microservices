package com.codefountain.employeesearch.service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.codefountain.employeesearch.model.Employee;

@Service
public class EmployeeSearchService {

	
	private static Map<Long, Employee> employeeRespository = null;
	
	static {
		Stream<String> employeeStream = Stream.of("1, Somnath Musib, Java, Designer", "2, John Doe, Python, Developer", "3, Jose Joe, .Net, Architect");
		employeeRespository = employeeStream.map(employeeStr -> {
			String[] tokens = employeeStr.split(",");
			return createEmployee(Long.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3]);
		}).collect(Collectors.toMap(Employee::getEmployeeId, employee -> employee));
	}
	
	private static Employee createEmployee(Long employeeId, String empployeeName, String practiceArea, String designation) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(empployeeName);
		employee.setPracticeArea(practiceArea);
		employee.setDesignation(designation);
		employee.setCompanyInfo("Code Fountain");
		return employee;	
	}
	
	
	public Employee findById(Long id){
		return employeeRespository.get(id);
	}
	
	public Collection<Employee> findAll(){
		return employeeRespository.values();
	}
}
