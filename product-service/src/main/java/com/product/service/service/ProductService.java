package com.product.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.service.bean.Product;
import com.product.service.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		List<Product> arlProduct = productRepository.findAll();
		return arlProduct;
	}
	
	public Product getProductById(int nProductId) {
		Optional<Product> product = productRepository.findById(nProductId);
		return product.get();
	}
	
	public Product addProduct(Product product) {
		Product productResponse = productRepository.save(product);
		return productResponse;
	}
}
