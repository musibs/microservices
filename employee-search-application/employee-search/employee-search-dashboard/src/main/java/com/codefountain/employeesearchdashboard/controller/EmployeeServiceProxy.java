package com.codefountain.employeesearchdashboard.controller;

import java.util.Collection;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codefountain.employeesearchdashboard.model.EmployeeInfo;

@FeignClient(name="EmployeeSearch")
@RibbonClient(name="EmployeeSearch")
public interface EmployeeServiceProxy {

	@RequestMapping("/employee/find/{id}")
	public EmployeeInfo findById(@PathVariable("id") Long id);
	
	@RequestMapping("/employee/findall")
	public Collection<EmployeeInfo> findAll();
}
