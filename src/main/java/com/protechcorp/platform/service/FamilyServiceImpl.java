package com.protechcorp.platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.protechcorp.platform.model.Family;
import com.protechcorp.platform.repository.FamilyRepository;

public class FamilyServiceImpl implements FamilyService {

	@Autowired
	private FamilyRepository familyRepository;
	
	@Override
	public Family save(Family t) throws Exception {
		// TODO Auto-generated method stub
		return familyRepository.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		familyRepository.deleteById(id);
		
	}

	@Override
	public Optional<Family> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return familyRepository.findById(id);
	}

	@Override
	public List<Family> findAll() throws Exception {
		// TODO Auto-generated method stub
		return familyRepository.findAll();
	}
	

}
