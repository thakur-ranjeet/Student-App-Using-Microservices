package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<?> handlerStudentNotFound(StudentNotFoundException ex,WebRequest req)
	{
		ErrorDetails ae = new ErrorDetails(new Date(), ex.getMessage(),
                req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ae,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerGlobalException(Exception ex,WebRequest req)
	{
		ErrorDetails ae = new ErrorDetails(new Date(), ex.getMessage(),
                req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(ae,HttpStatus.NOT_FOUND);
	}
	
	
}

