package com.userservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int nUserId;
	
	@Column(name="user_name")
	private String strUserName;
	
	@Column(name="password")
	private String strPassword;
	
	@Column(name="email")
	private String strEmail;
	
	@Column(name="contact_no")
	private String strContactNumber;
	
	@Column(name="address")
	private String strAddress;
	
	public UserInfo() {
		super();
	}

	public UserInfo(int nUserId, String strUserName, String strPassword, String strEmail, String strContactNumber,
			String strAddress) {
		super();
		this.nUserId = nUserId;
		this.strUserName = strUserName;
		this.strPassword = strPassword;
		this.strEmail = strEmail;
		this.strContactNumber = strContactNumber;
		this.strAddress = strAddress;
	}

	public int getnUserId() {
		return nUserId;
	}

	public void setnUserId(int nUserId) {
		this.nUserId = nUserId;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getStrContactNumber() {
		return strContactNumber;
	}

	public void setStrContactNumber(String strContactNumber) {
		this.strContactNumber = strContactNumber;
	}

	public String getStrAddress() {
		return strAddress;
	}

	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}
}
