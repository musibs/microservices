package com.codefountain.employeesearchdashboard.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codefountain.employeesearchdashboard.model.EmployeeInfo;

@RefreshScope
@RestController
public class FeignEmployeeInfoController {

	@Autowired
	EmployeeServiceProxy employeeServiceProxy;
	
	@RequestMapping("/dashboard/feign/{myself}")
	public EmployeeInfo findMe(@PathVariable Long myself) {
		System.err.println("Somnath!!");
		return employeeServiceProxy.findById(myself);
	}
	
	@RequestMapping("/dashboard/feign/peers")
	public Collection<EmployeeInfo> findPeers(){
		return employeeServiceProxy.findAll();
	}
}
