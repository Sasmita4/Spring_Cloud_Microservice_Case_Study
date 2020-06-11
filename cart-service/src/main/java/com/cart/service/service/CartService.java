package com.cart.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.service.bean.Cart;
import com.cart.service.bean.Product;
import com.cart.service.bean.UserCartResponse;
import com.cart.service.proxy.ProductServiceProxy;
import com.cart.service.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductServiceProxy productServiceProxy;

	public void deleteProductFromCart(int nUserId, int nProductId) {
		List<Cart> arlCart= cartRepository.findAllBynUserId(nUserId);
		for(Cart cart : arlCart) {
			if(cart.getnProductId() == nProductId) {
				cartRepository.delete(cart);
			}
		}
	}

	public Cart addProductToCart(int nProductId, int nUserId) {
		Cart cartObj = new Cart();
		cartObj.setnUserId(nUserId);
		cartObj.setnProductId(nProductId);
		
		Cart responseObj = cartRepository.save(cartObj);
		
		return responseObj;
	}
	
	public UserCartResponse getUserCart(int nUserId) {
		
		List<Product> arlProducts = new ArrayList<Product>();
		UserCartResponse userCartResponse = new UserCartResponse();
		
		List<Cart> arlUserCart = cartRepository.findAllBynUserId(nUserId);
				
		if(!arlUserCart.isEmpty()) {
			for(Cart cart : arlUserCart ) {				
				arlProducts.add(getProductDetailsById(cart.getnProductId()));
			}
		}
		userCartResponse.setArlProducts(arlProducts);
		userCartResponse.setUserId(nUserId);
		
		return userCartResponse;
	}
	
	public Product getProductDetailsById(int nProductId) {
		Product productObj = productServiceProxy.getProductById(nProductId);
		return productObj;
	}
}
