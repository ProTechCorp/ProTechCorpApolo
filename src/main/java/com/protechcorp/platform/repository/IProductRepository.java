package com.protechcorp.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT p FROM Product p WHERE p.location.name=?1")
	List<Product>findByLocation(String nameLocation);
}
