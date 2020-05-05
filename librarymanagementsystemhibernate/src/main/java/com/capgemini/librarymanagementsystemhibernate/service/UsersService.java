package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public interface UsersService {
	boolean register(UsersBean info);

	UsersBean auth(String email, String password);

	boolean addBook(BookBean book);

	List<Integer> getBookIds();

	List<BookBean> searchBookById(int bId);

	List<BookBean> searchBookByTitle(String bookName);

	List<BookBean> searchBookByAuthor(String author);

	List<BookBean> getBooksInfo();

	boolean updateBook(BookBean bean);

	boolean removeBook(int bId);

	boolean request(int uId, int bId);

	List<RequestBean> showRequest();

	boolean issueBook(int bId, int uId);

	List<BorrowedBooksBean> borrowedBook(int uId);

	boolean returnBook(int bId, int uId, String status);

	List<UsersBean> showUsers();

	List<Integer> bookHistoryDetails(int uId);
}
