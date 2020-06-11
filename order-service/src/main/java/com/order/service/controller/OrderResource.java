package com.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.service.bean.Orders;
import com.order.service.service.OrderService;

@RestController
public class OrderResource {
	
	@Autowired
	OrderService orderService;
	
	// TODO: Add Order
	
	// TODO: Get Order
	
	// TODO: Update Order
	
	// TODO: Delete Order
	
	@PostMapping("/placeOrder/userId/{userId}/productId/{productId}")
	@HystrixCommand(fallbackMethod = "fallBackPlaceOrder")
	public ResponseEntity<String> placeOrder(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		Orders orderResponse = orderService.placeOrder(userId, productId);
		String strOrderPlaceRes = null;
		if (orderResponse != null) {
			strOrderPlaceRes = "Order Placed Successfully";
		} else {
			strOrderPlaceRes = "Threre is some error, please try again later!";
		}
		return new ResponseEntity<String>(strOrderPlaceRes, HttpStatus.OK);
	}
	
	public ResponseEntity<String> fallBackPlaceOrder(@PathVariable("userId") int userId, @PathVariable("productId") int productId) {
		return new ResponseEntity<String>("Service is Down..", HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}
