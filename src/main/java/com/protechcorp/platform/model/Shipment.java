package com.protechcorp.platform.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipments")
public class Shipment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "shippingDate")
	private Date shippingDate;
	
	
	@Column(name = "departureDate")
	private Date departureDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getShippingDate() {
		return shippingDate;
	}


	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	
	
}
