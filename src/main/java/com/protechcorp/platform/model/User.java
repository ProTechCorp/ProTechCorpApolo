package com.protechcorp.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Firstname cannot be empty")
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstname;
	
	@NotEmpty(message = "Lastname cannot be empty")
	@Column(name = "lastname", nullable = false, length = 50)
	private String lastname;
	
	@NotEmpty(message = "email cannot be empty")
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@NotEmpty(message = "password cannot be empty")
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	@NotEmpty(message = "Telephone cannot be empty")
	@Column(name = "telephone", nullable = false, length = 50)
	private String telephone;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
