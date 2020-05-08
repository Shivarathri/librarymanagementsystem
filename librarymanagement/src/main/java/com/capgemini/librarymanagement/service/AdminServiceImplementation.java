package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.factory.AdminFactory;

public class AdminServiceImplementation implements AdminServiceDAO {
	private AdminDAO dao = AdminFactory.getAdminDAO();

	public boolean register(AdminBean adm) {
		return dao.register(adm);
	}

	public AdminBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public boolean addBook(BookBean book) {

		return dao.addBook(book);
	}

	public List<BookBean> searchBookTitle(String bTitle) {

		return dao.searchBookTitle(bTitle);
	}

	public List<BookBean> searchBookAuthor(String bAuthor) {

		return dao.searchBookAuthor(bAuthor);
	}

	public List<BookBean> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public boolean removeBook(int bid) {

		return dao.removeBook(bid);
	}

	public List<Integer> getBookIds() {

		return dao.getBookIds();
	}

	public List<BookBean> getBooksInfo() {

		return dao.getBooksInfo();
	}

	public List<StudentBean> showUsers() {

		return dao.showUsers();
	}

	public List<RequestBean> showRequests() {

		return dao.showRequests();
	}

	public boolean bookIssue(StudentBean student, BookBean book) {

		return dao.bookIssue(student, book);
	}

	public boolean isBookReceived(StudentBean student, BookBean book) {

		return dao.isBookReceived(student, book);
	}

}
