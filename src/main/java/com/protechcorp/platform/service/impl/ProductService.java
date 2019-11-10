package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Product;
import com.protechcorp.platform.repository.IProductRepository;
import com.protechcorp.platform.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository productRepository;
	
	@Transactional
	@Override
	public Product save(Product entity) throws Exception {
		
		return productRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		productRepository.deleteById(id);
		
	}

	@Override
	public Optional<Product> findById(Long id) throws Exception {
		
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() throws Exception {
		
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByLocation(String nameLocation) {
		
		return productRepository.findByLocation(nameLocation);
	}

}
