package com.codefountain.employeesearch.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefountain.employeesearch.model.Employee;
import com.codefountain.employeesearch.service.EmployeeSearchService;

@RestController
@RefreshScope
public class EmployeeSearchController {

	@Autowired
	EmployeeSearchService employeeSearchService;
	
	@RequestMapping("/employee/find/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeSearchService.findById(id);
	}
	
	@RequestMapping("/employee/findall")
	public Collection<Employee> findAll(){
		return employeeSearchService.findAll();
	}
}
