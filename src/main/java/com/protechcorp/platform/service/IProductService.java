package com.protechcorp.platform.service;



import java.util.List;

import com.protechcorp.platform.model.Product;

public interface IProductService extends CrudService<Product>{

List<Product> findByLocation(String nameLocation);

}
