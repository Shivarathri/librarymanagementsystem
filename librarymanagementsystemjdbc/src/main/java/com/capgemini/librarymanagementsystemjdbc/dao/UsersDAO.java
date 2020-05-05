package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.IssueBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public interface UsersDAO {
	boolean register(UsersBean user);

	UsersBean login(String email, String password);

	boolean addBook(BookBean book);

	boolean updateBook(BookBean book);

	boolean removeBook(int bId);

	LinkedList<BookBean> getBookIds();

	LinkedList<BookBean> searchBookById(int bId);

	LinkedList<BookBean> searchBookByTitle(String bookName);

	LinkedList<BookBean> searchBookByAuthor(String author);

	LinkedList<BookBean> getBooksInfo();

	boolean request(int uId, int bId);

	List<RequestBookDetailsBean> showRequest();

	boolean issueBook(int bId, int uId);

	List<BorrowedBooksBean> borrowedBook(int uId);

	boolean returnBook(int bId, int uId, String status);

	List<UsersBean> showUsers();

	LinkedList<IssueBookDetailsBean> bookHistoryDetails(int uId);
}
