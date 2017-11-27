package com.vinodh.webservices.test.repository;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vinodh.webservices.springwebservices.repository.ProjectsRepository;
import com.vinodh.webservices.test.config.TestSpringAppConfig;

@RunWith(SpringRunner.class)
@ContextHierarchy(value = @ContextConfiguration(classes = TestSpringAppConfig.class))
@EnableTransactionManagement
@Transactional
public class ProjectsRepositoryTest {

	@Autowired
	ProjectsRepository projectsRepository;

	@Before
	public void setup() {

	}

	@Test
	public void getAllProjects() {
		Assert.assertFalse(projectsRepository.getAllProjects("VINODH").isEmpty());
		Assert.assertEquals(4, projectsRepository.getAllProjects("VINODH").size());
	}

	@Test
	public void projectsCount() {
		Assert.assertEquals(4, projectsRepository.projectsCount("VINODH", null));
	}

	@After
	public void cleanup() {

	}

}
