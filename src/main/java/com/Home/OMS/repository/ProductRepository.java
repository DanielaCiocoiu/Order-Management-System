package com.Home.OMS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Home.OMS.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
List<Product> findByName(String name);


}
