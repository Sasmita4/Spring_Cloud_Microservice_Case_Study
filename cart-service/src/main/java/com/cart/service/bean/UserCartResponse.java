package com.cart.service.bean;

import java.util.List;

public class UserCartResponse {

	private int userId;
	private List<Product> arlProducts;
	
	public UserCartResponse() {
		super();
	}
	
	public UserCartResponse(int userId, List<Product> arlProducts) {
		super();
		this.userId = userId;
		this.arlProducts = arlProducts;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Product> getArlProducts() {
		return arlProducts;
	}
	public void setArlProducts(List<Product> arlProducts) {
		this.arlProducts = arlProducts;
	}
	
	
}
