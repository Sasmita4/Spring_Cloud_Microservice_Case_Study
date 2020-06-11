package com.cart.service.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name="cartId")
	private int nCartId;
	
	@Column(name="userId")
	private int nUserId;
	
	@Column(name="productId")
	private int nProductId;

	public Cart() {
		super();
	}

	public Cart(int nCartId, int nUserId, int nProductId) {
		super();
		this.nCartId = nCartId;
		this.nUserId = nUserId;
		this.nProductId = nProductId;
	}

	public int getnCartId() {
		return nCartId;
	}

	public void setnCartId(int nCartId) {
		this.nCartId = nCartId;
	}

	public int getnUserId() {
		return nUserId;
	}

	public void setnUserId(int nUserId) {
		this.nUserId = nUserId;
	}

	public int getnProductId() {
		return nProductId;
	}

	public void setnProductId(int nProductId) {
		this.nProductId = nProductId;
	}
}
