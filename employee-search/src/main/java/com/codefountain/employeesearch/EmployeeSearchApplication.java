package com.codefountain.employeesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSearchApplication.class, args);
	}

}
