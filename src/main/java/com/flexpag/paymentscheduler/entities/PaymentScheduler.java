package com.flexpag.paymentscheduler.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_scheduled_payments")
public class PaymentScheduler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPayment;

	private Double valuePayment;
	private Date datePayment;

	@Enumerated(EnumType.STRING)
	private PaymentSteps paymentStep;

	public PaymentScheduler(Long idPayment, Double valuePayment, Date datePayment) {
		this.idPayment = idPayment;
		this.valuePayment = valuePayment;
		this.datePayment = datePayment;
		paymentStep = PaymentSteps.PENDING;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public Long getIdPayment() {
		return idPayment;
	}

	public Double getValuePayment() {
		return valuePayment;
	}

	public PaymentSteps getPaymentStep() {
		return paymentStep;
	}

}
