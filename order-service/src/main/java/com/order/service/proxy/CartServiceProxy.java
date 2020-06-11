package com.order.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul")
public interface CartServiceProxy {
	@DeleteMapping("/cart-service/deleteProduct/userId/{userId}/productId/{productId}")
	public ResponseEntity<Integer> deleteProductFromCart(@PathVariable int userId, @PathVariable int productId);
}
