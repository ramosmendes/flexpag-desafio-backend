package com.flexpag.paymentscheduler.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	private String nameUser;
	private String emailUser;
	private Double balanceUser;

	@OneToOne
	@JoinColumn(name = "payment_schedule_id")
	private PaymentScheduler paymentScheduler;

	public User(Long idClient, String nameUser, String emailUser, Double balanceUser,
			PaymentScheduler paymentScheduler) {
		this.idUser = idClient;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
		this.balanceUser = balanceUser;
		this.paymentScheduler = paymentScheduler;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public Long getIdUser() {
		return idUser;
	}

	public Double getBalanceUser() {
		return balanceUser;
	}

	public PaymentScheduler getPaymentScheduler() {
		return paymentScheduler;
	}

	public void setPaymentScheduler(PaymentScheduler paymentScheduler) {
		this.paymentScheduler = paymentScheduler;
	}

}
