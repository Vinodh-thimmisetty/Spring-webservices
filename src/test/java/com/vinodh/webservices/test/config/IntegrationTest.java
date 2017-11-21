package com.vinodh.webservices.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.vinodh.webservices.springwebservices.SpringWebservicesApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SpringWebservicesApplication.class)
@AutoConfigureMockMvc
public class IntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void sampleTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/spring-webservices/hibernate/test"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
