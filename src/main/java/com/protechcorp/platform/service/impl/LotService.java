package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Lot;
import com.protechcorp.platform.repository.ILotRepository;
import com.protechcorp.platform.service.ILotService;



@Service
public class LotService implements ILotService {
	
	@Autowired
	private ILotRepository lotRepository;
	
	
	@Transactional
	@Override
	public Lot save(Lot lot) throws Exception {
		
		return lotRepository.save(lot);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		lotRepository.deleteById(id);
		
	}

	@Override
	public Optional<Lot> findById(Long id) throws Exception {
		
		return lotRepository.findById(id);
	}

	@Override
	public List<Lot> findAll() throws Exception {
	
		return lotRepository.findAll();
	}
	
	
}
