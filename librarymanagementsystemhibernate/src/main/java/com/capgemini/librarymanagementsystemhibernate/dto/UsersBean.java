package com.capgemini.librarymanagementsystemhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")

@SequenceGenerator(name="sequence1", initialValue=100001, allocationSize=100)
public class UsersBean {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence1")
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

}
