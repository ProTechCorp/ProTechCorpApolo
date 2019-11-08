package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Lot;
import com.protechcorp.platform.repository.ILotRepository;
import com.protechcorp.platform.service.ILotService;



@Service
public class LotService implements ILotService {
	
	@Autowired
	private ILotRepository lotRepository;
	
	

	@Override
	public Lot save(Lot t) throws Exception {
		// TODO Auto-generated method stub
		return lotRepository.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		lotRepository.deleteById(id);
		
	}

	@Override
	public Optional<Lot> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return lotRepository.findById(id);
	}

	@Override
	public List<Lot> findAll() throws Exception {
		// TODO Auto-generated method stub
		return lotRepository.findAll();
	}
	
	
}
