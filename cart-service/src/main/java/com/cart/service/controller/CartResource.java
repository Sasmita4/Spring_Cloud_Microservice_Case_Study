package com.cart.service.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.service.bean.Cart;
import com.cart.service.bean.Product;
import com.cart.service.bean.UserCartResponse;
import com.cart.service.service.CartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CartResource {
	
	@Autowired
	CartService cartService;
	
	/*
	 * To add product to cart
	 */
	@PostMapping("/addProduct/userId/{userId}/productId/{productId}")
	@HystrixCommand(fallbackMethod = "addProductToCartFallBack")
	public ResponseEntity<Cart> addProductToCart(@PathVariable("productId") int productId,
			@PathVariable("userId") int userId) {
		Cart userCart = cartService.addProductToCart(productId, userId);
		return new ResponseEntity<Cart>(userCart, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Cart> addProductToCartFallBack(@PathVariable("productId") int productId,
			@PathVariable("userId") int userId) {
		return new ResponseEntity<Cart>(new Cart(500, userId, productId), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * To delete product from cart
	 */
	@DeleteMapping("/deleteProduct/userId/{userId}/productId/{productId}")
	@HystrixCommand(fallbackMethod = "deleteProductFromCartFallBack")
	public ResponseEntity<Integer> deleteProductFromCart(@PathVariable int userId, @PathVariable int productId) {
		cartService.deleteProductFromCart(userId, productId);
		return new ResponseEntity<Integer>(productId, HttpStatus.OK);
	}
	
	public ResponseEntity<Integer> deleteProductFromCartFallBack(@PathVariable int userId, @PathVariable int productId) {
		return new ResponseEntity<Integer>(productId, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * Get UserCart
	 */
	@GetMapping("/findUserCart/{userId}")
	@HystrixCommand(fallbackMethod = "getUserCartFallBack")
	public ResponseEntity<UserCartResponse> getUserCart(@PathVariable int userId) {
		UserCartResponse userCartResponse = cartService.getUserCart(userId);
		return new ResponseEntity<UserCartResponse>(userCartResponse, HttpStatus.OK);
	}
	
	public ResponseEntity<UserCartResponse> getUserCartFallBack(@PathVariable int userId) {
		return new ResponseEntity<UserCartResponse>(
						new UserCartResponse(userId, Arrays.asList(new Product(10, "", "", "", 0.0))
					), 
					HttpStatus.INTERNAL_SERVER_ERROR
				);
	}	
}
