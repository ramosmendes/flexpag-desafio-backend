package com.flexpag.paymentscheduler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexpag.paymentscheduler.model.entities.PaymentScheduler;
import com.flexpag.paymentscheduler.model.enums.PaymentSchedulerSteps;
import com.flexpag.paymentscheduler.model.exceptions.IdNotFoundException;
import com.flexpag.paymentscheduler.services.PaymentSchedulerService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentSchedulerController {

	@Autowired
	private PaymentSchedulerService service;

	@PostMapping
	public ResponseEntity<Long> insert(@RequestBody PaymentScheduler payment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(payment));
	}

	@GetMapping("/{id}/step")
	public ResponseEntity<PaymentSchedulerSteps> steps(@PathVariable Long id) throws Exception {
		PaymentScheduler payment = service.findById(id).orElseThrow(() -> new IdNotFoundException("ID does not exist"));
		return ResponseEntity.status(HttpStatus.OK).body(payment.getPaymentSteps());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentScheduler> findById(@PathVariable Long id) throws Exception {
		PaymentScheduler payment = service.findById(id).orElseThrow(() -> new IdNotFoundException("ID does not exist"));
		return ResponseEntity.status(HttpStatus.OK).body(payment);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) throws Exception {
		service.findById(id).orElseThrow(() -> new IdNotFoundException("ID does not exist"));
		service.deleteById(id);
	}

}
