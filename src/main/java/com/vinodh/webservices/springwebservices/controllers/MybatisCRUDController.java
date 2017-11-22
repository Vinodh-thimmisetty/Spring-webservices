package com.vinodh.webservices.springwebservices.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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

import com.vinodh.webservices.springwebservices.domain.Employee;
import com.vinodh.webservices.springwebservices.domain.Greeting;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@RestController
@RequestMapping(value = "/spring-webservices/mybatis")
public class MybatisCRUDController {

	@Autowired
	EmployeeService<Employee> mybatisEmployeeService;

	@GetMapping(value = "/test")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "vinodh") String name) {
		return new Greeting(new AtomicLong().incrementAndGet(), name);
	}

	@GetMapping(value = "/isValidEmployee/{employeeId}")
	public ResponseEntity<Boolean> isValidEmployee(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(mybatisEmployeeService.isEmployeeExist(employeeId));
	}

	/**
	 * sample HATEOAS implementation
	 * (Hypertext as the Engine of Application State)
	 * 
	 * @param employeeId
	 * @return ResponseEntity<Employee>
	 */
	@GetMapping(value = "/getEmployee/{employeeId}")
	public ResponseEntity<Employee> findById(@PathVariable("employeeId") long employeeId) {
		Employee employee = mybatisEmployeeService.findById(employeeId);
		employee.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(MybatisCRUDController.class).findById(employeeId))
				.withSelfRel());
		employee.add(ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(MybatisCRUDController.class).findAllEmployees())
				.withRel("All Employees"));
		return ResponseEntity.ok(employee);
	}

	@GetMapping(value = "/getAllEmployees")
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return ResponseEntity.ok(mybatisEmployeeService.findAllEmployees());
	}

	@GetMapping(value = "/userslist")
	public ResponseEntity<List<Employee>> listAllUsers() {
		return new ResponseEntity<>(mybatisEmployeeService.findAllEmployees(), HttpStatus.OK);
	}

	@PutMapping(value = "/updateEmployee/{employeeId}")
	public ResponseEntity<Integer> updateEmployee(@PathVariable("employeeId") long employeeId,
			@RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		return ResponseEntity.ok(mybatisEmployeeService.updateEmployee(employee));
	}

	@PostMapping(value = "/mergeEmployee/{employeeId}")
	public ResponseEntity<Integer> mergeEmployee(@PathVariable("employeeId") long employeeId,
			@RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		return ResponseEntity.ok(mybatisEmployeeService.mergeEmployee(employee));

	}

	@PostMapping(value = "/saveNewEmployee")
	public ResponseEntity<Integer> saveEmployee(@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(mybatisEmployeeService.saveEmployee(employee));
	}

	@DeleteMapping(value = "/deleteEmployee/{employeeId}")
	public ResponseEntity<Integer> deleteEmployee(@PathVariable("employeeId") long employeeId) {
		return ResponseEntity.ok(mybatisEmployeeService.deleteEmployeeById(employeeId));
	}

	@DeleteMapping(value = "/deleteAllEmployees")
	public ResponseEntity<Integer> deleteAllEmployee() {
		return ResponseEntity.ok(mybatisEmployeeService.deleteAllEmployees());
	}

	@InitBinder
	public void stringTrimming(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("MM/DD/YYYY"), true));
	}

}
