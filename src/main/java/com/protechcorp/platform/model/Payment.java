package com.protechcorp.platform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "MonthlyPayment cannot be empty")
	@Column(name = "monthlyPayment", nullable = false, length = 50)
	private Long monthlyPayment;
	
	@Column(name = "entered_at")
	private Date enteredAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Long monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public Date getEnteredAt() {
		return enteredAt;
	}

	public void setEnteredAt(Date enteredAt) {
		this.enteredAt = enteredAt;
	}
	
	
}
