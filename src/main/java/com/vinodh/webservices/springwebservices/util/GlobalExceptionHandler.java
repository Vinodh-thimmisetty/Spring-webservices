package com.vinodh.webservices.springwebservices.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vinodh.webservices.springwebservices.domain.ApiErrorResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Common utility class to handle all type of Exceptions i.e., centralized
 * exception handling across all @RequestMapping methods
 * through @ExceptionHandler methods.
 * 
 * @credits: https://docs.spring.io/spring/docs/4.3.9.RELEASE/javadoc-api/org/springframework/web/servlet/mvc/method/annotation/ResponseEntityExceptionHandler.html
 *           http://www.baeldung.com/global-error-handler-in-a-spring-rest-api
 * 
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = ex.getContentType()
				+ " media type is not supported for this Request. Supported Content media types are ::"
				+ ex.getSupportedMediaTypes().toString();

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
				HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getLocalizedMessage(), Arrays.asList(error));

		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());

	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = ex.getMessage()
				+ " media type is not acceptable for this Request. Acceptable Content media types are ::"
				+ ex.getSupportedMediaTypes().toString();

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
				HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getLocalizedMessage(), Arrays.asList(error));

		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());

	}

	/**
	 * if wrong HTTP method is passed to a method i.e., POST instead of GET
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String error = ex.getMethod() + " is not supported for this Request. Supported methods are ::"
				+ ex.getSupportedHttpMethods().toString();

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(),
				HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), Arrays.asList(error));

		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}

	/**
	 * 404 exceptions
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,
				ex.getLocalizedMessage(), Arrays.asList(error));
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}

	/**
	 * 
	 * Missing Path Parameter
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error = ex.getVariableName() + " path variable is missing";

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
				ex.getLocalizedMessage(), Arrays.asList(error));
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}

	/**
	 * 
	 * Missing Request Parameter
	 * 
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " request parameter is missing";

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
				ex.getLocalizedMessage(), Arrays.asList(error));
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}

	/**
	 * 
	 * if any method argument data-type is mismatched
	 */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error = ex.getValue() + " should be of type " + ex.getRequiredType().getName();

		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
				ex.getLocalizedMessage(), Arrays.asList(error));
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}

	/**
	 * 
	 * Argument annotated with @Valid fails
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("Bean Validation failed:: {}");
		List<String> validationsList = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> x.getField() + ":" + x.getDefaultMessage()).collect(Collectors.toList());

		ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
				ex.getLocalizedMessage(), validationsList);
		return handleExceptionInternal(ex, apiErrorResponse, headers, apiErrorResponse.getHttpStatus(), request);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), Arrays.asList("error occurred"));

		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}

}
