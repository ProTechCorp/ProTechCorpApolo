package com.protechcorp.platform.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protechcorp.platform.model.Employee;
import com.protechcorp.platform.repository.IEmployeeRepository;
import com.protechcorp.platform.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Transactional
	@Override
	public Employee save(Employee entity) throws Exception {
		
		return employeeRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Optional<Employee> findById(Long id) throws Exception {
		
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAll() throws Exception {
		
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findByLocation(String nameLocation) {
		
		return employeeRepository.findByLocation(nameLocation);
	}

	
	}
	


	
	

