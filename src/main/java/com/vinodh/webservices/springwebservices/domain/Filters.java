package com.vinodh.webservices.springwebservices.domain;

import lombok.Data;

/**
 * 
 * Table Filters i.e., conditional statements that can be passed in WHERE Clause
 * of a SQL Query
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@Data
public class Filters {

	private String empName;
	private String projectName;
	private String countryName;
	private String clientName;
	private String projectStatus;
	// Paginations
	private int startsWith;
	private int maxResults;

}
