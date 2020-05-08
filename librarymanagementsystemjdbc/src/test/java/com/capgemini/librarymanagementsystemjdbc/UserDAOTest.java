package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.UsersDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.UsersDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;

public class UserDAOTest {
	private UsersDAO dao = new UsersDAOImplement();
	BookBean bookBean = new BookBean();
	UsersBean usersBean = new UsersBean();

	@Test
	public void testAddBookTrue() {
		bookBean.setbId(101);
		bookBean.setBookName("Java");
		bookBean.setAuthor("james");
		bookBean.setCategory("Java");
		bookBean.setPublisher("aaa");
		boolean status = dao.addBook(bookBean);
		Assertions.assertTrue(status);

	}

	@Test
	public void testAddBookFalse() {
		bookBean.setbId(101);
		bookBean.setBookName("Java");
		bookBean.setAuthor("james");
		bookBean.setCategory("Java");
		bookBean.setPublisher("aaa");
		boolean status = dao.addBook(bookBean);
		Assertions.assertFalse(status);

	}

	@Test
	public void testloginTrue() {
		UsersBean check = dao.login("ravi@gmail.com", "Password@123");
		Assertions.assertNotNull(check);
	}

	@Test
	public void testloginFalse() {
		UsersBean check = dao.login("ravi@gmail.com", "Password");
		Assertions.assertNull(check);
	}

	@Test
	public void testAddRegisterTrue() {
		usersBean.setuId(101);
		usersBean.setFirstName("Shivarathri");
		usersBean.setLastName("Ravi Kumar");
		usersBean.setEmail("ravi@gmail.com");
		usersBean.setPassword("Password@123");
		usersBean.setRole("student");

		boolean status = dao.register(usersBean);
		Assertions.assertTrue(status);
	}

	@Test
	public void testAddRegisterFalse() {
		usersBean.setuId(101);
		usersBean.setFirstName("Shivarathri");
		usersBean.setLastName("Ravi Kumar");
		usersBean.setEmail("ravi@gmail.com");
		usersBean.setPassword("Password@123");
		usersBean.setRole("student");

		boolean status = dao.register(usersBean);
		Assertions.assertFalse(status);
	}
	
	
	

	@Test
	public void testRemoveBookTrue() {
		boolean check = dao.removeBook(1);
		Assertions.assertTrue(check);
	}

	@Test
	public void testRemoveBookFalse() {
		boolean check = dao.removeBook(1);
		Assertions.assertFalse(check);
	}

	@Test
	public void testSearchBookById() {
		List<BookBean> beans = dao.searchBookById(1);
		Assertions.assertNotNull(beans);
	}

	@Test
	public void testSearchBookId() {
		List<BookBean> beans = dao.searchBookById(1);
		Assertions.assertNull(beans);
	}

	@Test
	public void testSearchBookByName() {
		List<BookBean> beans = dao.searchBookByTitle("Java");
		Assertions.assertNotNull(beans);
	}

	@Test
	public void testSearchBookName() {
		List<BookBean> beans = dao.searchBookByTitle("Java");
		Assertions.assertNull(beans);
	}

	@Test
	public void testSearchBookByAuthor() {
		List<BookBean> beans = dao.searchBookByAuthor("james");
		Assertions.assertNotNull(beans);
	}

	@Test
	public void testSearchBookAuthor() {
		List<BookBean> beans = dao.searchBookByAuthor("james");
		Assertions.assertNull(beans);
	}
	
	@Test
	public void testBookInfoTrue() {
	List<BookBean> getBooks = dao.getBooksInfo();	
	Assertions.assertNotNull(getBooks);
	}
	
	@Test
	public void testBookInfoFalse() {
	List<BookBean> getBooks = dao.getBooksInfo();	
	Assertions.assertEquals(1, actual);;
	}
	
}
