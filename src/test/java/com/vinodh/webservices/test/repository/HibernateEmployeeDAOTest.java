package com.vinodh.webservices.test.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vinodh.webservices.springwebservices.dao.EmployeeDAO;
import com.vinodh.webservices.test.config.TestSpringAppConfig;

/**
 * 
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringAppConfig.class)
@EnableTransactionManagement
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

	@After
	public void cleanup() {

	}
}
