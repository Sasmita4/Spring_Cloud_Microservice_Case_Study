package com.order.service.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.service.bean.Orders;
import com.order.service.proxy.CartServiceProxy;
import com.order.service.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CartServiceProxy cartServiceProxy;
	
	public Orders placeOrder(int userId, int productId) {
		Orders orderObj = new Orders();
		orderObj.setnCartId(10000001);
		orderObj.setnUserId(userId);
		orderObj.setnProductId(productId);
		orderObj.setOrderDate(new Date());
		orderObj.setnAmount(1004);
		orderObj.setnQuantity(2);
		Orders response = orderRepository.save(orderObj);
		if (response != null) {
			deleteOrderPlacedProductFromCart(userId, productId);
		}
		return response;
	}
	
	public void deleteOrderPlacedProductFromCart(int userId, int productId) {
		cartServiceProxy.deleteProductFromCart(userId, productId);
	}

}
