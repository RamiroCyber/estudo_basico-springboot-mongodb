package com.estudo.mongodb.estudomongodb.services.exceptions;

public class ObjectExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectExistsException(String msg) {
		super(msg);
	}

}
