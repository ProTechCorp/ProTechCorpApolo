package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protechcorp.platform.model.Inventory;

@Repository
public interface IInventoryRepository
 extends JpaRepository<Inventory, Long >{

}
