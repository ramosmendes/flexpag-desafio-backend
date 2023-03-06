package com.flexpag.paymentscheduler.handler;

import java.time.LocalDateTime;
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
	public Map<String, String> finishedPaymentException(PaidPaymentException ex) {
		Map<String, String> erros = new HashMap<>();
		erros.put("DateTime", LocalDateTime.now().toString());
		erros.put("Message", ex.getMessage());
		erros.put("Status", HttpStatus.BAD_REQUEST.toString());
		return erros;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public Map<String, String> idNotFoundException(IdNotFoundException ex) {
		Map<String, String> erros = new HashMap<>();
		erros.put("DateTime", LocalDateTime.now().toString());
		erros.put("Message", ex.getMessage());
		erros.put("Status", HttpStatus.NOT_FOUND.toString());
		return erros;
	}

}