package com.vinodh.webservices.springwebservices.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.webservices.springwebservices.domain.Employee;
import com.vinodh.webservices.springwebservices.domain.Greeting;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@RestController
@RequestMapping(value = "/spring-webservices")
public class SampleCRUDController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/test")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "vinodh") String name) {
		return new Greeting(new AtomicLong().incrementAndGet(), name);
	}

	@GetMapping(value = "/isValidEmployee/{employeeId}")
	public ResponseEntity<Boolean> isValidEmployee(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(employeeService.isEmployeeExist(employeeId));
	}

	@GetMapping(value = "/getEmployee/{employeeId}")
	public ResponseEntity<Employee> findById(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(employeeService.findById(employeeId));
	}

	@GetMapping(value = "/employeeList")
	public ResponseEntity<List<Employee>> listAllUsers() {
		return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
	}
}
