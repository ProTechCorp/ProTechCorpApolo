package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Category;
import com.protechcorp.platform.repository.ICategoryRepository;
import com.protechcorp.platform.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Transactional
	@Override
	public Category save(Category entity) throws Exception{
		
		return categoryRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		categoryRepository.deleteById(id);		
	}

	@Override
	public Optional<Category> findById(Long id) throws Exception {
		
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findAll() throws Exception {
		
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> fetchCategoryByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.fetchCategoryByName(name);
	}

}
