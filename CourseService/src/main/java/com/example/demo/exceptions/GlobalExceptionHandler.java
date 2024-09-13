package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<?> handlerStudentNotFound(CourseNotFoundException ex,WebRequest req)
	{
		ApiError ae=new ApiError(LocalDateTime.now(),ex.getLocalizedMessage()+"local message",ex, req.getDescription(false));
		return new ResponseEntity<ApiError>(ae,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerGlobalException(Exception ex,WebRequest req)
	{
		ApiError ae=new ApiError(LocalDateTime.now(),ex.getLocalizedMessage(),ex, req.getDescription(false));
		return new ResponseEntity<ApiError>(ae,HttpStatus.NOT_FOUND);
	}
	
	
}
