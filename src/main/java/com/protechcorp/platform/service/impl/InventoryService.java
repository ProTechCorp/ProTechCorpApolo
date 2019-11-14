package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.protechcorp.platform.model.Inventory;
import com.protechcorp.platform.repository.IInventoryRepository;
import com.protechcorp.platform.service.IInventoryService;

public class InventoryService implements IInventoryService {
	
	@Autowired
	private IInventoryRepository inventoryRepository;

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
