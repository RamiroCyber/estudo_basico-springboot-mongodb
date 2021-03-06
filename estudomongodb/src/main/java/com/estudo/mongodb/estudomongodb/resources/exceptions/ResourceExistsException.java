package com.estudo.mongodb.estudomongodb.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudo.mongodb.estudomongodb.services.exceptions.ObjectExistsException;

@ControllerAdvice
public class ResourceExistsException {

	@ExceptionHandler(ObjectExistsException.class)
	public ResponseEntity<StandardError> objectExists(ObjectExistsException object, HttpServletRequest request) {

		var status = HttpStatus.BAD_REQUEST;
		var error = new StandardError(System.currentTimeMillis(), status.value(), "Object exists", object.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(error);
	}
}