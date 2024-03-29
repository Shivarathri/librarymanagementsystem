package com.capgemini.librarymanagementsystemspring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")

@SequenceGenerator(name = "sequence1", initialValue = 100001, allocationSize = 100)
public class UsersBean {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence1")
	private int uId;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private long mobile;
	@Column
	private String role;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
