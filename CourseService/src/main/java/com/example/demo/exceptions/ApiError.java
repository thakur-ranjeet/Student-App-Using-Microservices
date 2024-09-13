package com.example.demo.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

class ApiError {

	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   private String url;
	  
	   

	   ApiError(LocalDateTime timestamp,String message, Exception ex,String url) {
	     
	       
	       this.timestamp = timestamp;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	}