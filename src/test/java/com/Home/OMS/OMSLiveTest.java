package com.Home.OMS;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.home.springboot.OMS.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OMSLiveTest {
	 private static final String API_ROOT = "http://localhost:8080/api/products";

	    @Test
	    public void whenGetAllProducts_thenOK() {
	        final Response response = RestAssured.get(API_ROOT);
	        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	    }

	    @Test
	    public void whenGetProductsByName_thenOK() {
	        final Product product = createRandomProduct();
	        createProductAsUri(product);

	        final Response response = RestAssured.get(API_ROOT + "/title/" + product.getName());
	        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	        assertTrue(response.as(List.class)
	            .size() > 0);
	    }

	    @Test
	    public void whenGetCreatedProductById_thenOK() {
	        final Product product = createRandomProduct();
	        final String location = createProductAsUri(product);

	        final Response response = RestAssured.get(location);
	        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	        assertEquals(product.getName(), response.jsonPath()
	            .get("name"));
	    }

	    @Test
	    public void whenGetNotExistProductByName_thenNotFound() {
	        final Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));
	        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	    }

	 

	    // ===============================

	    private Product createRandomProduct() {
	        final Product product = new Product();
	        product.setName(randomAlphabetic(10));
	        return product;
	    }

	    private String createProductAsUri(Product product) {
	        final Response response = RestAssured.given()
	            .contentType(MediaType.APPLICATION_JSON_VALUE)
	            .body(product)
	            .post(API_ROOT);
	        return API_ROOT + "/" + response.jsonPath()
	            .get("id");
	    }
}
