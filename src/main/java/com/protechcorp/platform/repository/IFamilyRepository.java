package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Family;

@Repository
public interface IFamilyRepository
 extends JpaRepository<Family, Long>{

}
