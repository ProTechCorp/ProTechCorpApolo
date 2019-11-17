package com.protechcorp.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Category;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("select c from Category c where c.name like %?1%")
	List<Category> fetchCategoryByName(String name);
}
