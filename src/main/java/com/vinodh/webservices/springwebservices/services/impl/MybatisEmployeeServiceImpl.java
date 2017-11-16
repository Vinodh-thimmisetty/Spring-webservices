package com.vinodh.webservices.springwebservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinodh.webservices.springwebservices.domain.Employee;
import com.vinodh.webservices.springwebservices.repository.EmployeeRepository;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@Service("mybatisEmployeeService")
public class MybatisEmployeeServiceImpl implements EmployeeService<Employee> {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findById(long id) {

		return employeeRepository.findById(id);
	}

	@Override
	public Employee findByName(String name) {

		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAllEmployees();
	}

	@Override
	public int saveEmployee(Employee employee) {

		return employeeRepository.saveEmployee(employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public int mergeEmployee(Employee employee) {

		return employeeRepository.mergeEmployee(employee);
	}

	@Override
	public int deleteEmployeeById(long id) {

		return employeeRepository.deleteEmployeeById(id);
	}

	@Override
	public int deleteAllEmployees() {

		return employeeRepository.deleteAllEmployees();
	}

	@Override
	public boolean isEmployeeExist(long employeeId) {
		return (employeeRepository.isEmployeeExist(employeeId) > 0) ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public int saveMultipleEmployees(List<Employee> employees) {
		return 0;
	}

}
