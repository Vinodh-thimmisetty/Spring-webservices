package com.vinodh.webservices.springwebservices.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private Integer addressId;
	private Long employeeId;
	private String streetName;
	private String cityName;
	private String stateName;
	private String countryName;
	private String zipCode;
}
