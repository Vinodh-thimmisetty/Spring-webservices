package com.vinodh.webservices.springwebservices.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinodh.webservices.springwebservices.dao.EmployeeDAO;
import com.vinodh.webservices.springwebservices.domain.EmployeeEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Transactional
@Slf4j
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public EmployeeEntity findById(long id) {
		log.info("Fetching Employee info of {}", id);
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(EmployeeEntity.class, Long.valueOf(id));
	}

	@Override
	public EmployeeEntity findByName(String employeeName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createNamedQuery("employee.findbyName");
		query.setParameter("employeeName", employeeName);
		return (EmployeeEntity) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> findAllEmployees() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createNamedQuery("employee.findAllEmployees");
		return query.getResultList();

	}

	@Override
	public int saveEmployee(EmployeeEntity employee) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(employee);
		return employee.getEmployeeId().intValue();
	}

	@Override
	public int updateEmployee(EmployeeEntity employee) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(employee);
		return employee.getEmployeeId().intValue();
	}

	@Override
	public int mergeEmployee(EmployeeEntity employee) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(employee);
		return employee.getEmployeeId().intValue();
	}

	@Override
	public int deleteEmployeeById(long employeeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createNamedQuery("employee.deleteEmployeeById").setParameter("employeeId", employeeId)
				.executeUpdate();
	}

	@Override
	public int deleteAllEmployees() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createNamedQuery("employee.deleteAllEmployees").executeUpdate();
	}

	@Override
	public boolean isEmployeeExist(long employeeId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createNamedQuery("employee.isEmployeeExist").setParameter("employeeId",
				employeeId);
		return !query.getResultList().isEmpty();
	}

	@Override
	public int saveMultipleEmployees(List<EmployeeEntity> employees) {
		return 0;
	}

}
