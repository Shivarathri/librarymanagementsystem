package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public interface StudentDAO {
	
	boolean register (StudentBean std);
	StudentBean auth(String email,String password);
	LinkedList<BookBean> searchBookTitle(String bname);
	LinkedList<BookBean> searchBookAuthor(String bAuthor);
	LinkedList<BookBean> searchBookType(String bookType);
	LinkedList<Integer> getBookIds();
	LinkedList<BookBean> getBooksInfo();
	public RequestBean bookRequest(StudentBean student, BookBean book);
	public RequestBean bookReturn(StudentBean student, BookBean book);
	
}
