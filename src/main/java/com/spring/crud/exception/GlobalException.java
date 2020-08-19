package com.spring.crud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	//handle specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundExcepion(ResourceNotFoundException exception,WebRequest request){
		ErrorDetails details=new ErrorDetails(new Date(), exception.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity(details,HttpStatus.NOT_FOUND);
	}
	
	
	//handle specific exception
		@ExceptionHandler(APIException.class)
		public ResponseEntity<?> handleAPIExceptionExcepion(APIException exception,WebRequest request){
			ErrorDetails details=new ErrorDetails(new Date(), exception.getLocalizedMessage(), request.getDescription(false));
			return new ResponseEntity(details,HttpStatus.NOT_FOUND);
		}
	
	//handle Global exception
		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> handleGlobalExcepion(Exception exception,WebRequest request){
			ErrorDetails details=new ErrorDetails(new Date(), exception.getLocalizedMessage(), request.getDescription(false));
			return new ResponseEntity(details,HttpStatus.NOT_FOUND);
		}

}
