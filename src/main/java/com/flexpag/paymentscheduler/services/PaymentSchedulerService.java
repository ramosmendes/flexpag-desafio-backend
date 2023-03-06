package com.flexpag.paymentscheduler.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexpag.paymentscheduler.model.entities.PaymentScheduler;
import com.flexpag.paymentscheduler.model.enums.PaymentSchedulerSteps;
import com.flexpag.paymentscheduler.model.exceptions.PaidPaymentException;
import com.flexpag.paymentscheduler.repositories.PaymentSchedulerRepository;

@Service
public class PaymentSchedulerService {

	@Autowired
	private PaymentSchedulerRepository paymentSchedulerRepository;
	
	public List<PaymentScheduler> findAll() {
		return paymentSchedulerRepository.findAll();
	}

	public Optional<PaymentScheduler> findById(Long id) {
		return paymentSchedulerRepository.findById(id);
	}

	public Long insert(PaymentScheduler payment) {
		payment.setPaymentSteps(PaymentSchedulerSteps.PENDING);
		return paymentSchedulerRepository.save(payment).getId();
	}

	public PaymentSchedulerSteps step(Long id) {
		return paymentSchedulerRepository.findById(id).get().getPaymentSteps();
	}

	public void deleteById(Long id) {
		paymentSchedulerRepository.findById(id).map(payment -> {
			if (payment.getPaymentSteps().equals(PaymentSchedulerSteps.PENDING)) {
				paymentSchedulerRepository.deleteById(id);
			} else {
				new PaidPaymentException("The payment step has already been paid");
			}
			return payment;
		});
	}

}
