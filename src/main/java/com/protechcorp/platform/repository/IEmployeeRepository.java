package com.protechcorp.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("SELECT p FROM Product p WHERE p.location.name=?1")
	List<Employee>findByLocation(String nameLocation);

	
}
