package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protechcorp.platform.model.Family;

public interface FamilyRepository
 extends JpaRepository<Family, Long>{

}
