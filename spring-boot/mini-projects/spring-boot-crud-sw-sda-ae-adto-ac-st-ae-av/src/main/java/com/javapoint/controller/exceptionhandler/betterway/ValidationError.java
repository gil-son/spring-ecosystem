package com.javapoint.controller.exceptionhandler.betterway;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	List<FieldMessage> listErrors = new ArrayList<>();
	
	public List<FieldMessage> getListErrors() {
		return listErrors;
	}

	public void addErrors(String fieldError, String message) {
		listErrors.add(new FieldMessage(fieldError, message));
	}
	
}
