package com.flexpag.paymentscheduler.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flexpag.paymentscheduler.model.exceptions.IdNotFoundException;
import com.flexpag.paymentscheduler.model.exceptions.PaidPaymentException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(PaidPaymentException.class)
	public Map<String, String> paidPaymentException(PaidPaymentException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("Error date",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString());
		error.put("Message", ex.getMessage());
		return error;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public Map<String, String> idNotFoundException(IdNotFoundException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("Error date",
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString());
		error.put("Message", ex.getMessage());
		return error;
	}

}