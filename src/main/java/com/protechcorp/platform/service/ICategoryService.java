package com.protechcorp.platform.service;

import java.util.List;

import com.protechcorp.platform.model.Category;

public interface ICategoryService extends CrudService<Category>{
	List<Category> fetchCategoryByName(String name) throws Exception;
}
