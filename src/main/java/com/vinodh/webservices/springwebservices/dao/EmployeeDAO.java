package com.vinodh.webservices.springwebservices.dao;

import java.util.List;

import com.vinodh.webservices.springwebservices.domain.EmployeeEntity;

public interface EmployeeDAO {

	EmployeeEntity findById(long employeeId);

	EmployeeEntity findByName(String name);

	List<EmployeeEntity> findAllEmployees();

	int saveEmployee(EmployeeEntity employee);

	int saveMultipleEmployees(List<EmployeeEntity> employees);

	int updateEmployee(EmployeeEntity employee);

	int mergeEmployee(EmployeeEntity employee);

	int deleteEmployeeById(long employeeId);

	int deleteAllEmployees();

	boolean isEmployeeExist(long employeeId);

}
