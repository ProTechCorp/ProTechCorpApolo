package com.protechcorp.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Family;

@Repository
public interface IFamilyRepository extends JpaRepository<Family, Long>{

	@Query("select f from Family f where f.name like %?1%")
	List<Family> fetchFamilyByName(String name);
	
}