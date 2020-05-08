package com.capgemini.librarymanagement.db;

import java.util.ArrayList;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;

public class DB {
	public static final ArrayList<AdminBean> admin = new ArrayList<AdminBean>();
	public static final ArrayList<BookBean> book = new ArrayList<BookBean>();
	public static final ArrayList<StudentBean> student = new ArrayList<StudentBean>();
	public static final ArrayList<RequestBean> request = new ArrayList<RequestBean>();

	public static void addDummyDetails() {
		AdminBean adminBean = new AdminBean();
		adminBean.setEmail("prasant@gmail.com");
		adminBean.setPassword("Password@123");
		adminBean.setAname("Prasant");
		adminBean.setAid(123456);
		admin.add(adminBean);

		StudentBean studentBean = new StudentBean();
		studentBean.setEmail("ravi@gmail.com");
		studentBean.setPassword("Password@123");
		studentBean.setSname("Ravi");
		studentBean.setSid(111111);
		student.add(studentBean);

		BookBean bookBean = new BookBean();
		bookBean.setBid(1234);
		bookBean.setBname("java");
		bookBean.setBauthor("james");
		bookBean.setCategory("aaa");
		bookBean.setPublishername("aaa");
		book.add(bookBean);

	}

}
