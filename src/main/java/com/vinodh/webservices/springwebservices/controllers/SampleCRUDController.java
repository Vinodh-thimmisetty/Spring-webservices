package com.vinodh.webservices.springwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.webservices.springwebservices.domain.Employee;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@RestController("/spring-webservices")
public class SampleCRUDController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/userslist")
	public ResponseEntity<List<Employee>> listAllUsers() {
		return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
	}
}
