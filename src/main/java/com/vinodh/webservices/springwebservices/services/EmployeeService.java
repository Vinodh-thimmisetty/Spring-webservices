package com.vinodh.webservices.springwebservices.services;

import java.util.List;

public interface EmployeeService<T> {

	T findById(long id);

	T findByName(String name);

	List<T> findAllEmployees();

	int saveEmployee(T employee);

	int saveMultipleEmployees(List<T> employees);

	int updateEmployee(T employee);

	int mergeEmployee(T employee);

	int deleteEmployeeById(long id);

	int deleteAllEmployees();

	boolean isEmployeeExist(long employeeId);

}
