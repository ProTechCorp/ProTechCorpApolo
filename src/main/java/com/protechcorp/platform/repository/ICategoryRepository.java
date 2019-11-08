package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protechcorp.platform.model.Category;



public interface CategoryRepository extends JpaRepository<Category, Long> {

}
