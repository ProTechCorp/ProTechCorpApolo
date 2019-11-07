package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.WareHouse;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse, Long> {

}
