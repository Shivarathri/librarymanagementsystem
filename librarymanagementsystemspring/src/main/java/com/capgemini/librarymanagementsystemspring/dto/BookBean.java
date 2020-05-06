package com.capgemini.librarymanagementsystemspring.dto;

import java.io.Serializable;

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
@Table(name = "bookbean")

@SequenceGenerator(name="sequence2", initialValue=1001, allocationSize=100)
public class BookBean implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence2")
	private int bId;
	@Column
	private String bookName;
	@Column
	private String author;
	@Column
	private String category;
	@Column
	private String publisher;

}
