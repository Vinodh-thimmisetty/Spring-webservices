package com.vinodh.webservices.springwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parents {

	private Long employeeId;
	private String fatherName;
	private Integer fatherPhone;
	private Integer motherName;
	private Integer motherPhone;

}
