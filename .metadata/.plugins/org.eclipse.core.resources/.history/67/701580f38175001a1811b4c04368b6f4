package com.capgemini.librarymanagement.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.db.DB;
import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.exception.AdminException;

public class AdminDAOImplementation implements AdminDAO {

	public boolean register(AdminBean adm) {

		for (AdminBean adminbean : DB.admin) {
			if (adminbean.getEmail().equals(adm.getEmail())) {
				return false;
			}

		}
		DB.admin.add(adm);
		return true;
	}

	public AdminBean auth(String regEmail, String regPassword) {
		for (AdminBean bean : DB.admin) {
			if (bean.getEmail().equals(regEmail) && bean.getPassword().equals(regPassword)) {
				System.out.println("Login succssful");
				return bean;
			} 
			throw new AdminException ("Invalid email and password");

		}
		return null;
	}


	public boolean delete(BookBean book) {
		for (BookBean bean : DB.book) {
			if (bean.getBid()==book.getBid()) {
				return false;
			}

		}
		DB.book.add(book);
		return true;
	}


	public boolean addBook(BookBean book) {
		for (BookBean bean : DB.book) {
			if (bean.getBid()==book.getBid()) {
				return false;
			}
		}
		DB.book.add(book);
		return true;
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
			throw new AdminException("Book not found");
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
			throw new AdminException("Book not found");
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

	public int updateBook(int bid) {
		int status=0;
		for(int i=0;i<=DB.book.size()-1;i++)
		{
			BookBean retrievedBook=DB.book.get(i);
			int retrievedId=retrievedBook.getBid();
			if(bid==retrievedId)
			{
				status++;
				break;
			}
		}
		throw new AdminException("Book not updated");


	}

	public boolean removeBook(int bid) {
		boolean status=false;
		for(int i=0;i<=DB.book.size()-1;i++)
		{
			BookBean retrievedBook=DB.book.get(i);
			int retrievedId=retrievedBook.getBid();
			if(bid==retrievedId)
			{
				status=true;
				DB.book.remove(i);
				break;
			}
		}
		return status;

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

	public List<StudentBean> showUsers() {
		List<StudentBean> usersList = new LinkedList<StudentBean>();
		for (StudentBean studentBean : DB.student) {

			studentBean.getSid();
			studentBean.getSname();
			studentBean.getEmail();
			studentBean.getBooksBorrowed();
			usersList.add(studentBean);

		}
		return usersList;
	}

	public List<RequestBean> showRequests() {
		List<RequestBean> infos = new LinkedList<RequestBean>();
		for (RequestBean requestInfo : DB.request) {
			requestInfo.getBookInfo();
			requestInfo.getStudentInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			infos.add(requestInfo);
		}
		return infos;
	}

	public boolean bookIssue(StudentBean student, BookBean book) {
		boolean isValid = false;

		RequestBean requestInfo = new RequestBean();

		int noOfBooksBorrowed = student.getBooksBorrowed();
		for (RequestBean info : DB.request) {
			if (info.getStudentInfo().getSid() == student.getSid()) {
				if (info.getBookInfo().getBid() == book.getBid()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)

		{


			for (BookBean info2 : DB.book) {
				if (info2.getBid() == book.getBid()) {
					book = info2;
				}

			}

			for (StudentBean studentInfo : DB.student) {
				if (studentInfo.getSid() == student.getSid()) {
					student = studentInfo;
					noOfBooksBorrowed = student.getBooksBorrowed();

				}

			}

			if (noOfBooksBorrowed < 3) {

				boolean isRemoved = DB.book.remove(book);
				if (isRemoved) {

					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					student.setBooksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new AdminException("Book can't be borrowed");
				}

			} else {
				throw new AdminException("Student Exceeds maximum limit");
			}

		} else {
			throw new AdminException("Book data or Student data is incorrect");

		}
	}

	public boolean isBookReceived(StudentBean student, BookBean book) {

		boolean isValid = false;
		RequestBean requestInfo1 = new RequestBean();
		for (RequestBean requestInfo : DB.request) {

			if (requestInfo.getBookInfo().getBid() == book.getBid()
					&& requestInfo.getStudentInfo().getSid() == student.getSid() 
					&& requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {

			book.setBauthor(requestInfo1.getBookInfo().getBauthor());
			book.setBname(requestInfo1.getBookInfo().getBname());
			DB.book.add(book);
			DB.request.remove(requestInfo1);


			for (StudentBean userInfo2 : DB.student) {
				if (userInfo2.getSid() == student.getSid()) {
					student = userInfo2;
				}

			}
			int noOfBooksBorrowed = student.getBooksBorrowed();
			noOfBooksBorrowed--;
			student.setBooksBorrowed(noOfBooksBorrowed);
			return true;

		}

		return false;
	}

}
