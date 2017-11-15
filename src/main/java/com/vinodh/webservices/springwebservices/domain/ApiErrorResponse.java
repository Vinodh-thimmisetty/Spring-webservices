package com.vinodh.webservices.springwebservices.domain;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiErrorResponse {

	private int httpStatusCode;
	private HttpStatus httpStatus;
	private String message;
	private List<String> errors;
}
