package com.protechcorp.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protechcorp.platform.model.Inventory;

public interface InventoryRepository
 extends JpaRepository<Inventory, Long >{

}
