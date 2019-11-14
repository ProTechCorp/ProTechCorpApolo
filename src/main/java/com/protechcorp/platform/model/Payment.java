package com.protechcorp.platform.model;




import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

<<<<<<< HEAD:src/main/java/com/protechcorp/platform/model/Payment.java
=======


>>>>>>> 989f937e388d9f1b1fda28e0e0c7a7b77f330588:src/main/java/com/protechcorp/platform/model/Lot.java
@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "MonthlyPayment cannot be empty")
	@Column(name = "monthlyPayment", nullable = false, length = 50)
	private Long monthlyPayment;
	
<<<<<<< HEAD:src/main/java/com/protechcorp/platform/model/Payment.java
	@Column(name = "entered_at")
	private Date enteredAt;

=======

	
>>>>>>> 989f937e388d9f1b1fda28e0e0c7a7b77f330588:src/main/java/com/protechcorp/platform/model/Lot.java
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


	

	
	
}
