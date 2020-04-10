package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean info);
	UsersBean auth(String email, String password);
	boolean addBook(BookBean book);
	LinkedList<BookBean> getBookIds();
	LinkedList<BookBean> searchBookById(int bId);
	LinkedList<BookBean> searchBookByTitle(String bookName);
	LinkedList<BookBean> searchBookByAuthor(String author);
	LinkedList<BookBean> getBooksInfo();
	boolean updateBook(BookBean bean);
	boolean removeBook(int bId);
	boolean request(int uId, int bId);
	List<RequestBean> showRequest();
	boolean issueBook(int bId,int uId);
	List<BorrowedBooks> borrowedBook(int uId);
	boolean returnBook(int bId, int uId, String status);
	List<UsersBean> showUsers();
	LinkedList<Integer> bookHistoryDetails(int uId);
}
