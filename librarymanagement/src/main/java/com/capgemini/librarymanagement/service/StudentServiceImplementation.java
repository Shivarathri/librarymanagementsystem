package com.capgemini.librarymanagement.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.factory.StudentFactory;

public class StudentServiceImplementation implements StudentServiceDAO {

	private StudentDAO dao=StudentFactory.getStudentDAO();

	public boolean register(StudentBean std) {
		return dao.register(std);
	}

	public StudentBean auth(String email, String password) {
		return dao.auth(email, password);
	}

	public LinkedList<BookBean> searchBookTitle(String bname) {
		return dao.searchBookTitle(bname);
	}

	public LinkedList<BookBean> searchBookAuthor(String bAuthor) {
		return dao.searchBookAuthor(bAuthor);
	}

	public LinkedList<BookBean> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public LinkedList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public LinkedList<BookBean> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public RequestBean bookRequest(StudentBean student, BookBean book) {
		
		return dao.bookRequest(student, book);
	}

	public RequestBean bookReturn(StudentBean student, BookBean book) {
		
		return dao.bookReturn(student, book);
	}
	
	

	


}
