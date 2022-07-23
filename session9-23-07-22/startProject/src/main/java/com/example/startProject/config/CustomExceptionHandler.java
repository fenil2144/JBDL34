package com.example.startProject.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.startProject.dtos.ErrorResponse;

@Configuration
@ControllerAdvice
public class CustomExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		List<String> errors = fieldErrors.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		//custom logic
		
		ErrorResponse errorResponse = new ErrorResponse(errors,HttpStatus.NOT_ACCEPTABLE,ex.getMessage()
				,"ERR_501");
		
		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
		
	}
	
//	@org.springframework.web.bind.annotation.ExceptionHandler(IndexOutOfBoundsException.class)
//	public ResponseEntity handleMethodArgumentNotValidException(IndexOutOfBoundsException ex) {
//		
//
//		//custom logic
//		List
//		
//		ErrorResponse errorResponse = new ErrorResponse(,HttpStatus.NOT_ACCEPTABLE,ex.getMessage()
//				,"ERR_556");
//		
//		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
//		
//	}
	
//	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//	public ResponseEntity handleMethodArgumentNotValidException(Exception ex) {
//		
//		BindingResult result = ex.getBindingResult();
//		List<FieldError> fieldErrors = result.getFieldErrors();
//		
//		List<String> errors = fieldErrors.stream()
//				.map(x -> x.getDefaultMessage())
//				.collect(Collectors.toList());
//		//custom logic
//		
//		ErrorResponse errorResponse = new ErrorResponse(errors,HttpStatus.NOT_ACCEPTABLE,ex.getMessage()
//				,"ERR_501");
//		
//		return new ResponseEntity(errorResponse,HttpStatus.NOT_ACCEPTABLE);
//		
//	}

}
