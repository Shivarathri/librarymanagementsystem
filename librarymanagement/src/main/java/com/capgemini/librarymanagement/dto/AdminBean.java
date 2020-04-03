package com.capgemini.librarymanagement.dto;

import java.io.Serializable;

public class AdminBean implements Serializable {
	private int aid;
	private String aname;
	private String email;
	private String phone;
	private String password;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String regMobile) {
		this.phone = regMobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
