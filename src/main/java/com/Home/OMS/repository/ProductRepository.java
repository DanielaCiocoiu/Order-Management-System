package com.Home.OMS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.home.springboot.OMS.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
List<Product> findByName(String name);


}
