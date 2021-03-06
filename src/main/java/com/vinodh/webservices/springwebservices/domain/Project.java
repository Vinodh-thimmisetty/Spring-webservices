package com.vinodh.webservices.springwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

	private Integer projectId;
	private Long employeeId;
	private String projectName;
	private String clientName;
	private Integer projectPeriod;
	private String projectStatus;

}
