package com.vinodh.webservices.test.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinodh.webservices.springwebservices.controllers.HibernateCRUDController;
import com.vinodh.webservices.springwebservices.entity.EmployeeEntity;
import com.vinodh.webservices.springwebservices.services.EmployeeService;

import info.solidsoft.mockito.java8.api.WithAdditionalMatchers;
import info.solidsoft.mockito.java8.api.WithMockito;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HibernateCRUDController.class)
public class HibernateCRUDControllerTest implements WithMockito, WithAdditionalMatchers {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	EmployeeService<EmployeeEntity> employeeServiceMock;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testController() {
		 
	}

}
