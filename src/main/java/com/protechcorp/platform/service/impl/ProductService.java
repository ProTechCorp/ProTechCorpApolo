package com.protechcorp.platform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Product;
import com.protechcorp.platform.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public Product save(Product t) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.save(t);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}

	@Override
	public Optional<Product> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
