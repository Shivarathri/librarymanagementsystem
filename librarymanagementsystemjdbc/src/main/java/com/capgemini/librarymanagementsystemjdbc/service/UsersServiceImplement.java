package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.UsersDAO;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemjdbc.dto.IssueBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;

public class UsersServiceImplement implements UsersService {
	private UsersDAO dao = LibraryFactory.getUsersDao();

	@Override
	public boolean register(UsersBean user) {
		// TODO Auto-generated method stub
		return dao.register(user);
	}

	@Override
	public UsersBean login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.login(email, password);
	}

	@Override
	public boolean addBook(BookBean book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	@Override
	public boolean updateBook(BookBean book) {
		// TODO Auto-generated method stub
		return dao.updateBook(book);
	}

	@Override
	public List<BookBean> getBookIds() {
		// TODO Auto-generated method stub
		return dao.getBookIds();
	}

	@Override
	public List<BookBean> searchBookById(int bId) {
		// TODO Auto-generated method stub
		return dao.searchBookById(bId);
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		// TODO Auto-generated method stub
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return dao.searchBookByAuthor(author);
	}

	@Override
	public List<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

	@Override
	public boolean request(int uId, int bId) {
		// TODO Auto-generated method stub
		return dao.request(uId, bId);
	}

	@Override
	public List<RequestBookDetailsBean> showRequest() {
		// TODO Auto-generated method stub
		return dao.showRequest();
	}

	@Override
	public boolean issueBook(int bId, int uId) {
		// TODO Auto-generated method stub
		return dao.issueBook(bId, uId);
	}

	@Override
	public List<BorrowedBooksBean> borrowedBook(int uId) {
		// TODO Auto-generated method stub
		return dao.borrowedBook(uId);
	}

	@Override
	public boolean returnBook(int bId, int uId, String status) {
		// TODO Auto-generated method stub
		return dao.returnBook(bId, uId, status);
	}

	@Override
	public boolean removeBook(int bId) {
		// TODO Auto-generated method stub
		return dao.removeBook(bId);
	}

	@Override
	public List<UsersBean> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

	@Override
	public List<IssueBookDetailsBean> bookHistoryDetails(int uId) {
		// TODO Auto-generated method stub
		return dao.bookHistoryDetails(uId);
	}

}
