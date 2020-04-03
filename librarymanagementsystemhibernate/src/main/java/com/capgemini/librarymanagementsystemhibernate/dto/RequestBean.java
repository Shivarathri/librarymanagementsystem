package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
@Inheritance
@Entity
@Table (name = "RequestBean")
public class RequestBean implements Serializable {
	@Id
	//@SequenceGenerator(name="seq", sequenceName="seq") @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	@Column(name = "id", updatable = false, nullable = false)

	@Column
	private int rid;
	@Column
	@GeneratedValue
	private BookBean bookInfo;
	@Column
	private UsersBean usersInfo;
	@GeneratedValue
	@Column
	private boolean isIssued;
	@Column
	private boolean isReturned;
	@Column

	private LocalDate issuedDate;
	@Column
	private LocalDate returnedDate;

	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public BookBean getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookBean bookInfo) {
		this.bookInfo = bookInfo;
	}
	public UsersBean getUsersInfo() {
		return usersInfo;
	}
	public void setUsersInfo(UsersBean usersInfo) {
		this.usersInfo = usersInfo;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
}
