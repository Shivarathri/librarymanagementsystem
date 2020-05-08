package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public interface StudentServiceDAO {

	boolean register(StudentBean std);

	StudentBean auth(String email, String password);

	List<BookBean> searchBookTitle(String bname);

	List<BookBean> searchBookAuthor(String bAuthor);

	List<BookBean> searchBookType(String bookType);

	List<Integer> getBookIds();

	List<BookBean> getBooksInfo();

	public RequestBean bookRequest(StudentBean student, BookBean book);

	public RequestBean bookReturn(StudentBean student, BookBean book);

}
