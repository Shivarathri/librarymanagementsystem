package com.capgemini.librarymanagementsystemhibernate.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.factory.UsersFactory;

public class UsersServiceImp implements UsersService {
	UsersDAO dao = UsersFactory.getUsersDAO();
	public boolean register(UsersBean info) {
		// TODO Auto-generated method stub
		return dao.register(info);
	}

	public UsersBean auth(String email, String password) {
		// TODO Auto-generated method stub
		return dao.auth(email, password);
	}

	public boolean addBook(BookBean book) {
		// TODO Auto-generated method stub
		return dao.addBook(book);
	}

	public BookBean searchBookTitle(String bname) {
		// TODO Auto-generated method stub
		return dao.searchBookTitle(bname);
	}

	public BookBean searchBookAuthor(String bAuthor) {
		// TODO Auto-generated method stub
		return dao.searchBookAuthor(bAuthor);
	}

	public BookBean searchBookType(int bid) {
		// TODO Auto-generated method stub
		return dao.searchBookType(bid);
	}

	public boolean updateBook(BookBean bean) {
		// TODO Auto-generated method stub
		return dao.updateBook(bean);
	}

	public boolean removeBook(int bid) {
		// TODO Auto-generated method stub
		return dao.removeBook(bid);
	}

	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return dao.getBookIds();
	}

	public LinkedList<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return dao.getBooksInfo();
	}

	public List<UsersBean> showUsers() {
		// TODO Auto-generated method stub
		return dao.showUsers();
	}

	public List<RequestBean> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	public boolean bookIssue(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return dao.bookIssue(student, book);
	}

	public boolean isBookReceived(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return dao.isBookReceived(student, book);
	}

	public RequestBean requestBook(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return dao.requestBook(student, book);
	}

	public boolean returnBook(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return dao.returnBook(student, book);
	}

	
}
