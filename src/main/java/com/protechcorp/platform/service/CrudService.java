package com.protechcorp.platform.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
	
	public T save(T t) throws Exception;
	public void deleteById(Long id) throws Exception;
	public Optional<T> findById(Long id) throws Exception;
	public List<T> findAll() throws Exception;
	

}
