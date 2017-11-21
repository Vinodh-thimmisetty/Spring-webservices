package com.vinodh.webservices.test.repository;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;
import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.vinodh.webservices.springwebservices.dao.EmployeeDAO;
import com.vinodh.webservices.springwebservices.entity.AddressEntity;
import com.vinodh.webservices.springwebservices.entity.EmployeeEntity;
import com.vinodh.webservices.springwebservices.entity.ParentsEntity;
import com.vinodh.webservices.springwebservices.entity.ProjectsEntity;
import com.vinodh.webservices.test.config.TestSpringAppConfig;

import pl.pojo.tester.internal.utils.CollectionUtils;

/**
 * 
 * All possible Junit Asserts are documented. Pick most reasonable one based on
 * method return type
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringAppConfig.class)
@EnableTransactionManagement
@Transactional
public class HibernateEmployeeDAOTest {

	@Autowired
	EmployeeDAO employeeDAO;

	@Before
	public void setup() {

	}

	@Test
	public void isEmployeeExist() {

		Assert.assertTrue(employeeDAO.isEmployeeExist(1));
		Assert.assertFalse(employeeDAO.isEmployeeExist(11));
	}

	@Test
	public void findById() {
		EmployeeEntity employeeEntity = employeeDAO.findById(1);
		/*if (employeeEntity != null) {
			Hibernate.initialize(employeeEntity.getAddresses());
			Hibernate.initialize(employeeEntity.getParents());
		}*/
		ParentsEntity parentsEntity = employeeEntity.getParents();
		Set<AddressEntity> addressEntities = employeeEntity.getAddresses();
		Set<ProjectsEntity> projectsEntities = employeeEntity.getProjects();

		Assert.assertEquals("Vinodh Kumar", employeeEntity.getEmployeeName());
		Assert.assertFalse(StringUtils.isBlank(employeeEntity.getEmployeeEmail()));
		// one-one mapping test for Parents Entity
		Assert.assertNotNull(parentsEntity);
		Assert.assertEquals("father", parentsEntity.getFatherName());
		// one-many mapping test for Address Entity
		Assert.assertEquals(2, addressEntities.size());
		Assert.assertThat("Address Details Exists for Employee", addressEntities.size(),
				Matchers.is(Matchers.equalTo(2)));
		// one-many mapping test for Projects Entity
		Assert.assertEquals(2, projectsEntities.size());
		Assert.assertTrue("Projects exists for employee", CollectionUtils.isNotEmpty(projectsEntities));
		Assert.assertFalse(projectsEntities.isEmpty());
	}

	@After
	public void cleanup() {

	}
}
