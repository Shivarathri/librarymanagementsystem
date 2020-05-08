package com.capgemini.librarymanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dao.AdminDAOImplementation;
import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;

public class UserDAOTest {
	private AdminDAO dao = new AdminDAOImplementation();
	BookBean bookBean = new BookBean();
	AdminBean adminBean = new AdminBean();

	@Test
	public void testAddBookTrue() {
		bookBean.setBid(1);
		bookBean.setBname("Java");
		bookBean.setBauthor("Java");
		bookBean.setCategory("Java");
		bookBean.setPublishername("aaa");
		boolean status = dao.addBook(bookBean);
		Assertions.assertTrue(status);

	}

	


	
}
