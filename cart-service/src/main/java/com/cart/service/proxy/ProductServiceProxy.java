package com.cart.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cart.service.bean.Product;

@FeignClient(name="zuul")
public interface ProductServiceProxy {

	@GetMapping("/product-service/findProductById/product/{id}")
	public Product getProductById(@PathVariable("id") int id);
}
