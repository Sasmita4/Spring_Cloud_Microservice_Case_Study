package com.order.service.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="order_id")
	int nOrderId;
	
	@Column(name="cart_id")
	int nCartId;

	@Column(name="user_id")
	int nUserId;
	
	@Column(name="product_id")
	int nProductId;
	
	@Column(name="order_date")
	Date orderDate;
	
	@Column(name="amount")
	int nAmount;
	
	@Column(name="quantity")
	int nQuantity;
	
	public Orders() {
		super();
	}

	public Orders(int nOrderId, int nCartId, int nUserId, int nProductId, Date orderDate, int nAmount, int nQuantity) {
		super();
		this.nOrderId = nOrderId;
		this.nCartId = nCartId;
		this.nUserId = nUserId;
		this.nProductId = nProductId;
		this.orderDate = orderDate;
		this.nAmount = nAmount;
		this.nQuantity = nQuantity;
	}

	public int getnOrderId() {
		return nOrderId;
	}

	public void setnOrderId(int nOrderId) {
		this.nOrderId = nOrderId;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getnAmount() {
		return nAmount;
	}

	public void setnAmount(int nAmount) {
		this.nAmount = nAmount;
	}

	public int getnQuantity() {
		return nQuantity;
	}

	public void setnQuantity(int nQuantity) {
		this.nQuantity = nQuantity;
	}
}
