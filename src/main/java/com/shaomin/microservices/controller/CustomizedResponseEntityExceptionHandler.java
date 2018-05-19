package com.shaomin.microservices.controller;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shaomin.microservices.domain.ProductNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ProductNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity<>(errorDetails(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ErrorDetails errorDetails(Exception ex, WebRequest request) {
		return ErrorDetails.builder().timestamp(Instant.now())
				.message(ex.getMessage()).details(request.getDescription(false)).build();
		
	}
}
