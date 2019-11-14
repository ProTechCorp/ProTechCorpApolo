package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Location;
import com.protechcorp.platform.repository.ILocationRepository;
import com.protechcorp.platform.service.ILocationService;

@Service
public class LocationService implements ILocationService {
@Autowired
private ILocationRepository warehouseRepository;

@Override
public Location save(Location t) throws Exception {
	// TODO Auto-generated method stub
	return warehouseRepository.save(t);
}

@Override
public void deleteById(Long id) throws Exception {
	// TODO Auto-generated method stub
	warehouseRepository.deleteById(id);
	
}

@Override
public Optional<Location> findById(Long id) throws Exception {
	// TODO Auto-generated method stub
	return warehouseRepository.findById(id);
}

@Override
public List<Location> findAll() throws Exception {
	// TODO Auto-generated method stub
	return warehouseRepository.findAll();
}

}
