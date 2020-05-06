package com.capgemini.librarymanagementsystemspring.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemspring.dto.BookBean;
import com.capgemini.librarymanagementsystemspring.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemspring.dto.RequestBean;
import com.capgemini.librarymanagementsystemspring.dto.UsersBean;

public interface UsersDAO {
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
