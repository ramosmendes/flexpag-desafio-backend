package com.flexpag.paymentscheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flexpag.paymentscheduler.model.entities.PaymentScheduler;

public interface PaymentSchedulerRepository extends JpaRepository<PaymentScheduler, Long> {

}
