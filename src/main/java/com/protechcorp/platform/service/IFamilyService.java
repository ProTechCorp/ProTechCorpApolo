package com.protechcorp.platform.service;

import java.util.List;

import com.protechcorp.platform.model.Family;

public interface IFamilyService extends CrudService<Family> {
	List<Family> fetchFamilyByName(String name) throws Exception;
	
}
