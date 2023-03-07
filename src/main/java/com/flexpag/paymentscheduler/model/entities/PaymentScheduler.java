package com.flexpag.paymentscheduler.model.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.flexpag.paymentscheduler.model.enums.PaymentSchedulerSteps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_payment")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentScheduler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Getter
	@Column(name = "value_payment", nullable = false)
	private Double value;

	@Getter
	@Column(name = "appointment_date", nullable = false)
	private LocalDate date;

	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	@Column(name = "step")
	private PaymentSchedulerSteps paymentSteps;
}
