package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Category;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
