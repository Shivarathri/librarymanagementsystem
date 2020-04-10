package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.EqualsAndHashCode.Exclude;
@Inheritance
@Entity
@Table (name = "request_details")
public class RequestBean implements Serializable {
	@EmbeddedId
	private CompositePK compositePK;
	@Column
	private String name;
	@Column
	private String bookName;
	
	
	
	public CompositePK getCompositePK() {
		return compositePK;
	}

	public void setCompositePK(CompositePK compositePK) {
		this.compositePK = compositePK;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BookBean getBooks() {
		return books;
	}

	public void setBooks(BookBean books) {
		this.books = books;
	}

	public UsersBean getUsers() {
		return users;
	}

	public void setUsers(UsersBean users) {
		this.users = users;
	}

	@Exclude
	@MapsId("bId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bId")
	private BookBean books;
	
	@Exclude
	@MapsId("uId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="uId")
	private UsersBean users;

	
}
