package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Lot;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long> {

}
