package com.product.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.product.service.bean.Product;
import com.product.service.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	ProductService productService;
	
	// TODO: Get All Products
	@GetMapping("/allProduct")
	@HystrixCommand(fallbackMethod = "getAllProductsFallBack")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> arlProducts = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(arlProducts, HttpStatus.OK);	
	}
	
	public ResponseEntity<List<Product>> getAllProductsFallBack() {
		return new ResponseEntity<List<Product>>(Arrays.asList(
				new Product(10, "", "", "", 0)), HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	// TODO: Get a Product Based on Product Id
	@GetMapping("/findProductById/product/{id}")
	@HystrixCommand(fallbackMethod = "getProductByIdFallBack")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	public ResponseEntity<Product> getProductByIdFallBack(@PathVariable("id") int id) {
		return new ResponseEntity<Product>(new Product(10, "", "", "", 0), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// TODO: Add Product
	@PostMapping("/product")
	@HystrixCommand(fallbackMethod = "addProductFallBack")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product responseProduct = productService.addProduct(product);
		return new ResponseEntity<Product>(responseProduct, HttpStatus.CREATED);	
	}
	
	public ResponseEntity<Product> addProductFallBack(@RequestBody Product product) {
		return new ResponseEntity<Product>(new Product(10, "", "", "", 0), HttpStatus.INTERNAL_SERVER_ERROR);	
	}
}
