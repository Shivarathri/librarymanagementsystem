package com.capgemini.librarymanagementsystemspring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity

@Table(name = "bookbean")

@SequenceGenerator(name = "sequence2", initialValue = 1001, allocationSize = 100)
public class BookBean implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence2")
	private int bId;
	@Column
	private String bookName;
	@Column
	private String author;
	@Column
	private String category;
	@Column
	private String publisher;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
