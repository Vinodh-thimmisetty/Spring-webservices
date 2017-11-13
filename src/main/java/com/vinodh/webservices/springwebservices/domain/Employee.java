package com.vinodh.webservices.springwebservices.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Employee {
	private Long employeeId;
	private String employeeName;
	private Long employeePhone;
	private Double employeeSalary;
	private String employeeEmail;
	private LocalDate employeeDOB;
}
