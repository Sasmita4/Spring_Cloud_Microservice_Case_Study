package com.cart.service.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "productId")
	private int nProductId;
	
	@Column(name = "productName")
	private String strProductName;
	
	@Column(name = "sku")
	private String strSku;
	
	@Column(name = "description")
	private String strDescription;
	
	@Column(name = "price")
	private Double dPrice;

	public Product() {
		super();
	}

	public Product(int nProductId, String strProductName, String strSku, String strDescription, Double dPrice) {
		super();
		this.nProductId = nProductId;
		this.strProductName = strProductName;
		this.strSku = strSku;
		this.strDescription = strDescription;
		this.dPrice = dPrice;
	}

	public int getnProductId() {
		return nProductId;
	}

	public void setnProductId(int nProductId) {
		this.nProductId = nProductId;
	}

	public String getStrProductName() {
		return strProductName;
	}

	public void setStrProductName(String strProductName) {
		this.strProductName = strProductName;
	}

	public String getStrSku() {
		return strSku;
	}

	public void setStrSku(String strSku) {
		this.strSku = strSku;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}

	public Double getdPrice() {
		return dPrice;
	}

	public void setdPrice(Double dPrice) {
		this.dPrice = dPrice;
	}
}
