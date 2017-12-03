package com.vinodh.webservices.test.bdd.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@ContextConfiguration(classes = SpringBootApplication.class)
@AutoConfigureMockMvc
public class TestController {

	@Autowired
	MockMvc mockMvc;

	private static ObjectMapper objectMapper = new ObjectMapper();

	private MockHttpServletRequest mockHttpServletRequest;
	private MockHttpServletResponse mockHttpServletResponse;

	protected void httpGetMethod(final String endPoint, Object... variables) throws Exception {
	//@formatter:off
		mockMvc
			.perform(MockMvcRequestBuilders
											.get(endPoint, variables)
											.accept(MediaType.APPLICATION_JSON)
					)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print())
		 	//.andExpect(MockMvcResultMatchers.jsonPath("$.employeeName").value("Vinodh Kumar"))
			.andReturn();
		//@formatter:on
	}

}
