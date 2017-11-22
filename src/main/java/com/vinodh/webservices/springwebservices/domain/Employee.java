package com.vinodh.webservices.springwebservices.domain;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false, exclude = { "parents", "projects", "addresses" })
public class Employee extends ResourceSupport {
	private Long employeeId;
	@NotBlank
	private String employeeName;
	@NotNull
	private Long employeePhone;
	@NotNull
	private Double employeeSalary;
	@Email
	private String employeeEmail;
	@Past
	private Date employeeDOB;
	private Parents parents;
	private Set<Project> projects;
	private Set<Address> addresses;
}
