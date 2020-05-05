package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "bookbean")
public class BookBean implements Serializable {
	@Id
	@Column(unique = true, nullable = false)
	private int bId;
	@Column
	private String bookName;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private String publisher;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
	private List<BookIssueDetailsBean> issueDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
	private List<RequestBean> requests;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
	private List<BorrowedBooksBean> borrowed;
}
