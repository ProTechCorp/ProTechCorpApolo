package com.protechcorp.platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.protechcorp.platform.model.Inventory;
import com.protechcorp.platform.repository.InventoryRepository;

public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public Inventory save(Inventory t) throws Exception {
		// TODO Auto-generated method stub
		return inventoryRepository.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		inventoryRepository.deleteById(id);
		
	}

	@Override
	public Optional<Inventory> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return inventoryRepository.findById(id);
	}

	@Override
	public List<Inventory> findAll() throws Exception {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}
}
