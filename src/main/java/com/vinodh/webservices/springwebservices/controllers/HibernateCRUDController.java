package com.vinodh.webservices.springwebservices.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.webservices.springwebservices.domain.EmployeeEntity;
import com.vinodh.webservices.springwebservices.domain.Greeting;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@RestController
@RequestMapping(value = "/spring-webservices/hibernate")
public class HibernateCRUDController {

	@Autowired
	EmployeeService<EmployeeEntity> hibernateEmployeeService;

	@GetMapping(value = "/test")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "vinodh") String name) {
		return new Greeting(new AtomicLong().incrementAndGet(), name);
	}

	@GetMapping(value = "/isValidEmployee/{employeeId}")
	public ResponseEntity<Boolean> isValidEmployee(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(hibernateEmployeeService.isEmployeeExist(employeeId));
	}

	@GetMapping(value = "/getEmployee/{employeeId}")
	public ResponseEntity<EmployeeEntity> findById(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(hibernateEmployeeService.findById(employeeId));
	}

	@GetMapping(value = "/getAllEmployees")
	public ResponseEntity<List<EmployeeEntity>> findAllEmployees() {
		return ResponseEntity.ok(hibernateEmployeeService.findAllEmployees());
	}

	@GetMapping(value = "/userslist")
	public ResponseEntity<List<EmployeeEntity>> listAllUsers() {
		return new ResponseEntity<>(hibernateEmployeeService.findAllEmployees(), HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee/{employeeId}")
	public ResponseEntity<Integer> updateEmployee(@PathVariable("employeeId") long employeeId,
			@RequestBody EmployeeEntity employee) {
		employee.setEmployeeId(employeeId);
		return ResponseEntity.ok(hibernateEmployeeService.updateEmployee(employee));
	}

	@PostMapping(value = "/mergeEmployee/{employeeId}")
	public ResponseEntity<Integer> mergeEmployee(@PathVariable("employeeId") long employeeId,
			@RequestBody EmployeeEntity employee) {
		employee.setEmployeeId(employeeId);
		return ResponseEntity.ok(hibernateEmployeeService.mergeEmployee(employee));

	}

	@PostMapping(value = "/saveNewEmployee")
	public ResponseEntity<Integer> saveEmployee(@Valid @RequestBody EmployeeEntity employee) {
		return ResponseEntity.ok(hibernateEmployeeService.saveEmployee(employee));
	}

	@DeleteMapping(value = "/deleteEmployee/{employeeId}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(hibernateEmployeeService.deleteEmployeeById(employeeId));
	}

	@DeleteMapping(value = "/deleteAllEmployees")
	public ResponseEntity<Integer> deleteAllEmployee() {
		return ResponseEntity.ok(hibernateEmployeeService.deleteAllEmployees());
	}

	@InitBinder
	public void stringTrimming(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/DD/YYYY"), true));
	}

}
