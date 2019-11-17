package com.protechcorp.platform.service;

import java.util.List;


import com.protechcorp.platform.model.Employee;

public interface IEmployeeService  extends CrudService<Employee>{
	
	List<Employee> findByLocation(String nameLocation);

}
