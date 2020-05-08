package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public interface AdminServiceDAO {

	boolean register(AdminBean adm);

	AdminBean auth(String email, String password);

	boolean addBook(BookBean book);

	List<BookBean> searchBookTitle(String bname);

	List<BookBean> searchBookAuthor(String bAuthor);

	List<BookBean> searchBookType(String bookType);

	boolean removeBook(int bid);

	List<Integer> getBookIds();

	List<BookBean> getBooksInfo();

	List<StudentBean> showUsers();

	List<RequestBean> showRequests();

	boolean bookIssue(StudentBean student, BookBean book);

	boolean isBookReceived(StudentBean student, BookBean book);

}
