package com.protechcorp.platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.WareHouse;
import com.protechcorp.platform.repository.WareHouseRepository;

@Service
public class WareHouseServiceImpl implements IWareHouseService {
@Autowired
private WareHouseRepository warehouseRepository;

@Override
public WareHouse save(WareHouse t) throws Exception {
	// TODO Auto-generated method stub
	return warehouseRepository.save(t);
}

@Override
public void deleteById(Long id) throws Exception {
	// TODO Auto-generated method stub
	warehouseRepository.deleteById(id);
	
}

@Override
public Optional<WareHouse> findById(Long id) throws Exception {
	// TODO Auto-generated method stub
	return warehouseRepository.findById(id);
}

@Override
public List<WareHouse> findAll() throws Exception {
	// TODO Auto-generated method stub
	return warehouseRepository.findAll();
}

}
