package com.vinodh.webservices.springwebservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinodh.webservices.springwebservices.dao.EmployeeDAO;
import com.vinodh.webservices.springwebservices.domain.EmployeeEntity;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

@Service("hibernateEmployeeService")
public class HbernateEmployeeServiceImpl implements EmployeeService<EmployeeEntity> {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public EmployeeEntity findById(long id) {
		return employeeDAO.findById(id);
	}

	@Override
	public EmployeeEntity findByName(String name) {

		return employeeDAO.findByName(name);
	}

	@Override
	public List<EmployeeEntity> findAllEmployees() {

		return employeeDAO.findAllEmployees();
	}

	@Override
	public int saveEmployee(EmployeeEntity employee) {

		return employeeDAO.saveEmployee(employee);
	}

	@Override
	public int saveMultipleEmployees(List<EmployeeEntity> employees) {

		return employeeDAO.saveMultipleEmployees(employees);
	}

	@Override
	public int updateEmployee(EmployeeEntity employee) {

		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public int mergeEmployee(EmployeeEntity employee) {

		return employeeDAO.mergeEmployee(employee);
	}

	@Override
	public int deleteEmployeeById(long id) {

		return employeeDAO.deleteEmployeeById(id);
	}

	@Override
	public int deleteAllEmployees() {

		return employeeDAO.deleteAllEmployees();
	}

	@Override
	public boolean isEmployeeExist(long employeeId) {

		return employeeDAO.isEmployeeExist(employeeId);
	}

}
