package com.Home.OMS.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Home.OMS.repository.ProductRepository;
import com.Home.OMS.web.ProductNotFoundException;
import com.home.springboot.OMS.Product;

@RestController
@RequestMapping(value="api/products")
public class ProductController {

	 @Autowired
	    private ProductRepository productRepository;
	
	 
	    public ProductController(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	    
	    
		@GetMapping
	    @ResponseStatus(HttpStatus.OK)
	    public Iterable<Product> findAll() {
	        return productRepository.findAll();
	    }
	 
	    @GetMapping(value = "/name/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public List <Product> findByName(@PathVariable String productName) {
	        return productRepository.findByName(productName);
	    }
	 
	    @GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public Product findOne(@PathVariable Long id) {
	        return productRepository.findById(id)
	          .orElseThrow(ProductNotFoundException::new);
	    }
	 
	  }
