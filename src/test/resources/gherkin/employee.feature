Feature: Spring boot Rest API
	In order to learn CRUD Operations on Employee
	As user/admin
	I want to query a url with different HTTP actions
	So that I can get/update/delete/create a new Employee
	
	Background: 
		Given I am a client
		
	Scenario: get employee id from employee table
		    Given employee id is a valid one
		    When I request the employee information by passing employee id "1"
		    Then the request was successful
		    And the response has the employee attributes:
		    	| attribute | type | value | 
		    	| employeeId | int | 1 | 
		    	| employeeName | String | "Vinodh" | 
		    	