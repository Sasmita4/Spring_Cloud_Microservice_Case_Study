package com.product.service.bean;

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
	private int nPrice;
	
	public Product() {
		super();
	}

	public Product(int nProductId, String strProductName, String strSku, String strDescription, int nPrice) {
		super();
		this.nProductId = nProductId;
		this.strProductName = strProductName;
		this.strSku = strSku;
		this.strDescription = strDescription;
		this.nPrice = nPrice;
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

	public int getnPrice() {
		return nPrice;
	}

	public void setnPrice(int nPrice) {
		this.nPrice = nPrice;
	}
}
