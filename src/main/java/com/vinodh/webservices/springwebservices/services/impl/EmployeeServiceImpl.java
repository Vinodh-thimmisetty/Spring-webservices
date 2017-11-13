package com.vinodh.webservices.springwebservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinodh.webservices.springwebservices.domain.Employee;
import com.vinodh.webservices.springwebservices.repository.EmployeeRepository;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findById(long id) {

		return null;
	}

	@Override
	public Employee findByName(String name) {

		return null;
	}

	@Override
	public List<Employee> findAllEmployees() {

		return null;
	}

	@Override
	public int saveEmployee(Employee employee) {

		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {

		return 0;
	}

	@Override
	public int mergeEmployee(Employee employee) {

		return 0;
	}

	@Override
	public int deleteEmployeeById(long id) {

		return 0;
	}

	@Override
	public int deleteAllEmployees() {

		return 0;
	}

	@Override
	public boolean isEmployeeExist(Employee employee) {

		return false;
	}

	@Override
	public int saveMultipleEmployees(List<Employee> employees) { 
		return 0;
	}

}
