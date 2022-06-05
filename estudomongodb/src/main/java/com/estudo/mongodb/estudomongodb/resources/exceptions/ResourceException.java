package com.estudo.mongodb.estudomongodb.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudo.mongodb.estudomongodb.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceException {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException object, HttpServletRequest request){
		
		var status =  HttpStatus.NOT_FOUND;
		var error = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", object.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
}
