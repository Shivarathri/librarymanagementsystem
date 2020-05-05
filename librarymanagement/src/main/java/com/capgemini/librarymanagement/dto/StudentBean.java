package com.capgemini.librarymanagement.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class StudentBean implements Serializable {
	private int sid;
	private String sname;
	private String email;
	private String password;
	private String sdepartment;
	private String phone;
	private Date issueDate;
	private Date returnDate;
	private int booksBorrowed;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getSdepartment() {
		return sdepartment;
	}

	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getBooksBorrowed() {
		return booksBorrowed;
	}

	public void setBooksBorrowed(int booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}

}
