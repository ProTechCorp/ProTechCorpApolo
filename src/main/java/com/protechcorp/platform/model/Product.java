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


@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "You need to specify a Product Name.")
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotEmpty(message = "You need to specify a LPN.")
	@Column(name = "lpn", nullable = false)
	private String lpn;
	
	@NotEmpty(message = "You need to specify a Product brand.")
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@NotEmpty(message = "You need to specify a description.")
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotEmpty(message = "You need to specify a location.")
	@Column(name = "location", nullable = false)
	private String location;
	
	@NotEmpty(message = "You need to specify a quantity.")
	@Column(name = "quantity", nullable = false)
	private String quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="family_id", nullable = false)
	private Family family;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="lot_id", nullable = false)
	private Lot lot;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLpn() {
		return lpn;
	}

	public void setLpn(String lpn) {
		this.lpn = lpn;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}
	
	
	
	

}
