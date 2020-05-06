package com.capgemini.librarymanagementsystemhibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "book_issue_details")
@SequenceGenerator(name="sequence4", initialValue=1, allocationSize=100)
public class BookIssueDetailsBean implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence4")
	private int id;
	@Column
	private int uId;
	@Column
	private int bId;
	@Column
	private Date issueDate;
	@Column
	private Date returnDate;

}
