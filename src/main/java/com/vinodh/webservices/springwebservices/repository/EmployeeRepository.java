package com.vinodh.webservices.springwebservices.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.vinodh.webservices.springwebservices.domain.Employee;

@Repository
public interface EmployeeRepository {

	Employee findById(@Param("employeeId") long employeeId);

	Employee findByName(@Param("employeeName") String employeeName);

	List<Employee> findAllEmployees();

	int saveEmployee(@Param("employee") Employee employee);

	int saveMultipleEmployees(@Param("employees") List<Employee> employees);

	int updateEmployee(@Param("employee") Employee employee);

	int mergeEmployee(@Param("employee") Employee employee);

	int deleteEmployeeById(@Param("employeeId") long employeeId);

	int deleteAllEmployees();

	boolean isEmployeeExist(@Param("employee") Employee employee);

}
