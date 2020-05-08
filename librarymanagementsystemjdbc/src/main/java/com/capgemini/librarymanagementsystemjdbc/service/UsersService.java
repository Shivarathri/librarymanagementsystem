package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemjdbc.dto.IssueBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean user);

	UsersBean login(String email, String password);

	boolean addBook(BookBean book);

	boolean updateBook(BookBean book);

	boolean removeBook(int bId);

	List<BookBean> getBookIds();

	List<BookBean> searchBookById(int bId);

	List<BookBean> searchBookByTitle(String bookName);

	List<BookBean> searchBookByAuthor(String author);

	List<BookBean> getBooksInfo();

	boolean request(int uId, int bId);

	List<RequestBookDetailsBean> showRequest();

	boolean issueBook(int bId, int uId);

	List<BorrowedBooksBean> borrowedBook(int uId);

	boolean returnBook(int bId, int uId, String status);

	List<UsersBean> showUsers();

	List<IssueBookDetailsBean> bookHistoryDetails(int uId);

}
