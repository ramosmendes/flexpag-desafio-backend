package com.flexpag.paymentscheduler.model.exceptions;

public class PaidPaymentException extends Exception {

	private static final long serialVersionUID = 1L;

	public PaidPaymentException(String msg) {
		super(msg);
	}
}
