package com.protechcorp.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="warehouses")
public class WareHouse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty(message = "RUC cannot be empty")
	@Column(name = "ruc", nullable = false, length = 50)
	private Long ruc;
	
	@NotEmpty(message = "Name cannot be empty")
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@NotEmpty(message = "Description cannot be empty")
	@Column(name = "description", nullable = false, length = 50)
	private String description;


}
