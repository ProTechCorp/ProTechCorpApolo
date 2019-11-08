package com.protechcorp.platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="inventories")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message= "FullStock cannot be empty")
	@Column(name="fullstock", nullable=false)
	private Long fullstock;
	
	@NotEmpty(message= "ReservedStock cannot be empty")
	@Column(name="reservedstock", nullable=false)
	private Long reservedstock;
	
	@NotEmpty(message= "AvailableStock cannot be empty")
	@Column(name="availablestock", nullable=false)
	private Long availablestock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFullstock() {
		return fullstock;
	}

	public void setFullstock(Long fullstock) {
		this.fullstock = fullstock;
	}

	public Long getReservedstock() {
		return reservedstock;
	}

	public void setReservedstock(Long reservedstock) {
		this.reservedstock = reservedstock;
	}

	public Long getAvailablestock() {
		return availablestock;
	}

	public void setAvailablestock(Long availablestock) {
		this.availablestock = availablestock;
	}
 
	
	
}
