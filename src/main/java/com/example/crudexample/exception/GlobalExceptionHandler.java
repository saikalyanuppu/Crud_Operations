package com.example.crudexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crudexample.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ApiResponse> handleBookNotFoundException(BookNotFoundException ex){
		ApiResponse response = new ApiResponse("error", ex.getMessage(), null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> handleGenericException(Exception ex){
		ApiResponse response = new ApiResponse("error", null, ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
