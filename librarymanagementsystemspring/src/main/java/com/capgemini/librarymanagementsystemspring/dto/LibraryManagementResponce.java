package com.capgemini.librarymanagementsystemspring.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LibraryManagementResponce {
	
	private boolean error;
	private String message;
	private UsersBean usersBean;
	private List<UsersBean> userList;
	private BookBean bookBean;
	private List<BookBean> bookList;
	private List<Integer> bookIdList;
	private RequestBean requestBean;
	private List<RequestBean> requestList;
	private BookIssueDetailsBean bookIssueDetailsBean;
	private List<BookIssueDetailsBean> bookIssueDetailsList;
	private BorrowedBooksBean borrowedBooksBean;
	private List<BorrowedBooksBean> borrowedBooksList;
}
