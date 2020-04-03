package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BookBean")
public class BookBean implements Serializable {
	@Id
	@Column (unique = true, nullable = false)
	private int bid;
	
	@Column
	private String bname;
	
	@Column (nullable = false)
	private String author;
	@Column (nullable = false)
	private String category;
	@Column (nullable = false)
	private String publishername;
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
	public String getPublishername() {
		return publishername;
	}
	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

}
