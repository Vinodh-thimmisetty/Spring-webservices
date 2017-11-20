package com.vinodh.webservices.springwebservices.repository;

import java.io.Serializable;

import com.vinodh.webservices.springwebservices.domain.Employee;

public class MybatisEmployeeRepository implements GenericCRUDRepository<Employee> {

	@Override
	public long count() {

		return 0;
	}

	@Override
	public void delete(Serializable arg0) {

	}

	@Override
	public void delete(Employee arg0) {

	}

	@Override
	public void delete(Iterable<? extends Employee> arg0) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean exists(Serializable arg0) {
		return false;
	}

	@Override
	public Iterable<Employee> findAll() {
		return null;
	}

	@Override
	public Iterable<Employee> findAll(Iterable<Serializable> arg0) {
		return null;
	}

	@Override
	public Employee findOne(Serializable arg0) {
		return null;
	}

	@Override
	public <S extends Employee> S save(S arg0) {
		return null;
	}

	@Override
	public <S extends Employee> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

}
