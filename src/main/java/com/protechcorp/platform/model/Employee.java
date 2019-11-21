package com.protechcorp.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "DNI cannot be empty")
	@Column(name = "dni", nullable = false, length = 50)
	private Long dni;
	
	@NotEmpty(message = "Firstname cannot be empty")
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstname;
	
	@NotEmpty(message = "Lastname cannot be empty")
	@Column(name = "lastname", nullable = false, length = 50)
	private String lastname;
	
	@NotEmpty(message = "Telephone cannot be empty")
	@Column(name = "telephone", nullable = false, length = 50)
	private String telephone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}
}
