package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class UsersBean implements Serializable {
	@Column (nullable = false)
	private String name;
	@Column
	@Id
	private int id;
	@Column (nullable = false)
	private String mobile;
	@Id
	@Column(unique = true, nullable = false)
	private String email;
	@Column (nullable = false)
	private String password;
	@Column (nullable = false)
	private String role;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<BookIssueDetails> getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(List<BookIssueDetails> issueDetails) {
		this.issueDetails = issueDetails;
	}

	public List<RequestBean> getRequests() {
		return requests;
	}

	public void setRequests(List<RequestBean> requests) {
		this.requests = requests;
	}

	public List<BorrowedBooks> getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(List<BorrowedBooks> borrowed) {
		this.borrowed = borrowed;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
	private List<BookIssueDetails> issueDetails;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
	private List<RequestBean> requests;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
	private List<BorrowedBooks> borrowed;

	
}
