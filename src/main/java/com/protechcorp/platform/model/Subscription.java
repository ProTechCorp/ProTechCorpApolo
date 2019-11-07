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

@Entity
@Table(name="subscriptions")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DecimalMin("1.00")
	@DecimalMax("5.00")
	@Column(name = "price", nullable = false, columnDefinition = "Decimal(8,2)")
	private Double price;
	
	@Column(name = "entered_at")
	private Date enteredAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getEnteredAt() {
		return enteredAt;
	}

	public void setEnteredAt(Date enteredAt) {
		this.enteredAt = enteredAt;
	}
	
	
}
