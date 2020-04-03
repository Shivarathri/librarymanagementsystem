package com.capgemini.librarymanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagement.dto.BookBean;

public interface BookDAO {
	void addBook(BookBean book);
	ArrayList<BookBean> searchBookTitle(String bookTitle);
	ArrayList<BookBean> searchBookAuthor(String bookAuthor);
	ArrayList<BookBean> searchBookType(String bookType);
	void updateBookPrice(int bId,double bookPrice);
	boolean removeBook(int bId);
	ArrayList<Integer> getBookIds();
	ArrayList<BookBean> getBookInfo();
	
	
}
