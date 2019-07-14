package com.Home.OMS.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Home.OMS.entity.Product;
import com.Home.OMS.repository.ProductRepository;
import com.Home.OMS.web.ProductNotFoundException;


@RequestMapping("api/products")
public class ProductController {

	 @Autowired
	    private ProductRepository productRepository;
	
	 
	    @GetMapping
	    public Iterable<Product> findAll() {
	        return productRepository.findAll();
	    }
	 
	    @GetMapping("/name/{productName}")
	    public List <Product> findByName(@PathVariable String productName) {
	        return productRepository.findByName(productName);
	    }
	 
	    @GetMapping("/{code}")
	    public Product findOne(@PathVariable Long code) {
	        return productRepository.findById(code)
	          .orElseThrow(ProductNotFoundException::new);
	    }
	 
	  
	 
	  
	 
	  	
	
}
