package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.db.DB;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.exception.AdminException;
import com.capgemini.librarymanagement.exception.StudentException;

public class StudentDAOImplementation implements StudentDAO {

	public boolean register(StudentBean std) {
		for (StudentBean studentbean : DB.student) {
			if (studentbean.getEmail().equals(std.getEmail())) {
				return false;
			}

		}
		DB.student.add(std);
		return true;
	}


	public StudentBean auth(String regEmail1, String regPassword1) {
		for (StudentBean bean : DB.student) {
			if (bean.getEmail().equals(regEmail1) && bean.getPassword().equals(regPassword1)) {
				System.out.println("Login succssful");
				return bean;
			} 
			throw new StudentException ("Invalid email and password");

		}
		return null;
	}


	public LinkedList<BookBean> searchBookTitle(String bname) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DB.book.size()-1;i++)
		{
			BookBean retrievedBook=DB.book.get(i);
			String retrievedBname=retrievedBook.getBname();
			if(bname.equals(retrievedBname))
			{
				searchList.add(retrievedBook);	
				return searchList;


			}
		}
		if(searchList.size()==0)
		{
			throw new StudentException ("Book is not found");
		}
		else
		{
			return searchList;
		}
	}


	public LinkedList<BookBean> searchBookAuthor(String bAuthor) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DB.book.size()-1;i++)
		{
			BookBean retrievedBook=DB.book.get(i);
			String retrievedBAuthor=retrievedBook.getBauthor();
			if(bAuthor.equals(retrievedBAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new StudentException ("Book is not found");
		}
		else
		{
			return searchList;
		}	
	}


	public LinkedList<BookBean> searchBookType(String bookType) {
		LinkedList<BookBean> searchList=new LinkedList<BookBean>();
		for(int i=0;i<=DB.book.size()-1;i++)
		{
			BookBean retrievedBook=DB.book.get(i);
			String retrievedBookType=retrievedBook.getCategory();
			if(bookType.equals(retrievedBookType))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new AdminException("Book not found");
		}
		else
		{
			return searchList;
		}	
	}


	public LinkedList<Integer> getBookIds() {
		LinkedList<Integer> idList=new LinkedList<Integer>();
		for(int i=0;i<=DB.book.size()-1;i++)
		{
			BookBean retrievedBook=DB.book.get(i);
			int retrievedBookId=retrievedBook.getBid();
			idList.add(retrievedBookId);
		}
		return idList;

	}


	public LinkedList<BookBean> getBooksInfo() {
		return DB.book;
	}


	public RequestBean bookRequest(StudentBean student, BookBean book) {
		boolean flag = false, 
		isRequestExists = false;
		RequestBean requestInfo = new RequestBean();
		StudentBean userInfo2 = new StudentBean();
		BookBean bookInfo2 = new BookBean();

		for (RequestBean requestInfo2 : DB.request) {
			if (book.getBid() == requestInfo2.getBookInfo().getBid()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (StudentBean user : DB.student) {
				if (user.getSid() == student.getSid()) {
					for (BookBean book1 : DB.book) {
						if (book1.getBid() == book1.getBid()) {
							userInfo2 = user;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setStudentInfo(userInfo2);
				DB.request.add(requestInfo);
				return requestInfo;
			}

		}

		throw new AdminException("Invalid request or you cannot request that book");
	}


	public RequestBean bookReturn(StudentBean student, BookBean book) {
		for (RequestBean requestInfo : DB.request) {

			if (requestInfo.getBookInfo().getBid() == book.getBid() &&
					requestInfo.getStudentInfo().getSid() == student.getSid() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  AdminException("Invalid return ");
	}

}
