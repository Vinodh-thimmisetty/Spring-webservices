package com.vinodh.webservices.test.bdd;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vinodh.webservices.test.bdd.util.TestController;

import cucumber.api.java.en.When;

public class EmployeeStep extends TestController {

	private static final TypeReference<Map<String, Object>> JSON_RESPONSE = new TypeReference<Map<String, Object>>() {
	};

	@When("^I request the employee information by passing employee id (\\d+) $")

	public void getEmployeeInformation(long employeeId) throws Exception {
		httpGetMethod("/spring-webservices/hibernate/getEmployee/" + employeeId, null);
	}
}
