package com.protechcorp.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Suppliers")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Firstname cannot be empty")
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstname;
	
	@NotEmpty(message = "Lastname cannot be empty")
	@Column(name = "lastname", nullable = false, length = 50)
	private String lastname;
	
	@NotEmpty(message = "RUC cannot be empty")
	@Column(name = "ruc", nullable = false, length = 50)
	private Long ruc;
	
	@NotEmpty(message = "Address cannot be empty")
	@Column(name = "address", nullable = false, length = 50)
	private String address;
	
	@NotEmpty(message="Description cannot be empty")
	@Column(name="description",nullable=false)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getRuc() {
		return ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
