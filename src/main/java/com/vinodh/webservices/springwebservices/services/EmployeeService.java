package com.vinodh.webservices.springwebservices.services;

import java.util.List;

import com.vinodh.webservices.springwebservices.domain.Employee;

public interface EmployeeService {

	Employee findById(long id);

	Employee findByName(String name);

	List<Employee> findAllEmployees();

	int saveEmployee(Employee employee);

	int saveMultipleEmployees(List<Employee> employees);

	int updateEmployee(Employee employee);

	int mergeEmployee(Employee employee);

	int deleteEmployeeById(long id);

	int deleteAllEmployees();

	boolean isEmployeeExist(Employee employee);

}
