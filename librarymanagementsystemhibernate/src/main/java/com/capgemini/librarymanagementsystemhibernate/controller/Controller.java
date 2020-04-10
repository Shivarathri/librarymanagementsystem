package com.capgemini.librarymanagementsystemhibernate.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;
import com.capgemini.librarymanagementsystemhibernate.factory.UsersFactory;
import com.capgemini.librarymanagementsystemhibernate.service.UsersService;
import com.capgemini.librarymanagementsystemhibernate.validation.Validation;


public class Controller {
	public static void main(String[] args) {
		doReg();
	}
	public static void doReg() {
		boolean flag = false;

		int regId = 0; 
		String regName = null;  
		String regMobile = null;
		String regEmail = null;
		String regPassword = null;

		int addBookId = 0;
		String addBookName = null; 
		String addBookAuthorName = null; 
		String addBookCategory = null;
		String addBookPublisher = null;

		int updateBookId = 0;
		String updateBookName = null; 
		String updateBookAuthorName = null; 
		String updateBookCategory = null;
		String updateBookPublisher = null;

		boolean loginStatus = true;
		Validation validation = new Validation();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("----------WELCOME TO LIBRARY-----------");
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to EXIT");
			System.out.println("---------------------------------------");

			UsersService service1 = UsersFactory.getUsersService();
			//do {
			try {
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					do {
						try {
							System.out.println("Enter ID :");
							regId = scanner.nextInt();
							validation.validatedId(regId);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Id should contains only digits");
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter  Name :");
							regName = scanner.next();
							validation.validatedName(regName);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Name should contains only Alphabates");
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					

					do {
						try {
							System.out.println("Enter Email :");
							regEmail = scanner.next();
							validation.validatedEmail(regEmail);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Email should be proper ");
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Password :");
							regPassword = scanner.next();
							validation.validatedPassword(regPassword);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Enter correct Password ");
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter Mobile :");
							regMobile = scanner.next();
							validation.validatedMobile(regMobile);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Mobile Number  should contains only numbers");
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					System.out.println("Enter the role");
					String regRole = scanner.next();

					UsersBean ai = new UsersBean();
					ai.setId(regId);
					ai.setName(regName);
					ai.setEmail(regEmail);
					ai.setPassword(regPassword);
					ai.setMobile(regMobile);
					ai.setRole(regRole);
					boolean check=service1.register(ai);
					if(check) {
						System.out.println("Registered");
					}else {
						System.out.println("Already user is registered");
					}
					break;
				case 2:
					System.out.println("Enter Email for Login");
					String email=scanner.next();
					System.out.println("Enter Password");
					String password=scanner.next();
					try {
						UsersBean loginInfo=service1.auth(email, password);
						if(loginInfo.getEmail().equals(email) && loginInfo.getPassword().equals(password)) {
							System.out.println("Logged In");
						}
						if(loginInfo.getRole().equals("admin")) {
							do {
								try {
									System.out.println("------------------------------------");
									System.out.println("Press 1 to Add book");
									System.out.println("Press 2 to Update the book");
									System.out.println("Press 3 to Remove book");
									System.out.println("Press 4 to get All the Book Ids");
									System.out.println("Press 5 to Search the Book by Id");
									System.out.println("Press 6 to Search the Book by Author");
									System.out.println("Press 7 to Search the Book by Title");
									System.out.println("Press 8 to Get All the Books Information");
									System.out.println("Press 9 to Issue Book");
									System.out.println("Press 10 to Show Users");
									System.out.println("Press 11 to Show Requests");
									System.out.println("Press 12 to check user book history");
									System.out.println("Press 13 to Log out");
									System.out.println("------------------------------------");
									int choice1 = scanner.nextInt();
									switch (choice1) {
									case 1:

										do {
											try {
												System.out.println("Enter Book-Id:");
												addBookId=scanner.nextInt();
												validation.validatedId(addBookId);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Id should contains only digits");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);


										do {
											try {
												System.out.println("Enter Book Name :");
												addBookName=scanner.next();
												validation.validatedName(addBookName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Author Name :");
												addBookAuthorName=scanner.next();
												validation.validatedName(addBookAuthorName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Category Name :");
												addBookCategory=scanner.next();
												validation.validatedName(addBookCategory);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Publisher Name :");
												addBookPublisher=scanner.next();
												validation.validatedName(addBookPublisher);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);
										/*
										 * System.out.println("enter no of copies"); int addCopies = scanner.nextInt();
										 */
										BookBean bi =new BookBean();
										bi.setBId(addBookId);
										bi.setBookName(addBookName);
										bi.setAuthor(addBookAuthorName);
										bi.setCategory(addBookCategory);
										bi.setPublisher(addBookPublisher);
										boolean check2=service1.addBook(bi);
										if(check2) {
											System.out.println("-----------------------------------------------");
											System.out.println("Added Book");
										}else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book not added");
										}
										break;	
									case 2:
										do {
											try {
												System.out.println("Enter the updated id :");
												updateBookId=scanner.nextInt();
												validation.validatedId(updateBookId);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Id should contains only digits");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);


										do {
											try {
												System.out.println("Enter BookName to be Updtaed :");
												updateBookName=scanner.next();
												validation.validatedName(updateBookName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookAuthor to be Updtaed :");
												updateBookAuthorName=scanner.next();
												validation.validatedName(updateBookAuthorName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookCategory to be Updtaed :");
												updateBookCategory=scanner.next();
												validation.validatedName(updateBookCategory);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookPublisher to be Updtaed :");
												updateBookPublisher=scanner.next();
												validation.validatedName(updateBookPublisher);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Name should contains only Alphabates");
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookBean bean2 = new BookBean();
										bean2.setBId(updateBookId);
										bean2.setBookName(updateBookName);
										bean2.setAuthor(updateBookAuthorName);
										bean2.setCategory(updateBookCategory);
										bean2.setPublisher(updateBookPublisher);

										boolean updated = service1.updateBook(bean2);
										if (updated) {
											System.out.println("Book is Updated");
										} else {
											System.out.println("Book is not Updated");
										}
										break;
									case 3:
										int removeId = 0;
										System.out.println("Enter Book-Id to Remove:");
										do {
											try {
												removeId=scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										boolean check3=service1.removeBook(removeId );
										if(check3) {
											System.out.println("Removed Book");
										}else {
											System.out.println("Book not removed");
										}
										break;

									case 4:
										LinkedList<BookBean> info = service1.getBookIds();
										for (BookBean bookBean : info) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
											} else {
												System.out.println("Books Ids is not present");
											}
										}
										break;
									case 5:

										int id = 0;
										System.out.println("Search the book by the Book-Id:");
										do {
											try {
												id = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookBean bean4 = new BookBean();
										bean4.setBId(id);
										List<BookBean> bookid = service1.searchBookById(id);
										for (BookBean bookBean : bookid) {

											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 6:

										String author = null;
										System.out.println("Search the book by the Author Name:");
										do {
											try {
												author = scanner.next();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookBean bean5 = new BookBean();
										bean5.setAuthor(author);
										List<BookBean> bookauthor = service1.searchBookByAuthor(author);
										for (BookBean bookBean : bookauthor) {

											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 7:

										String btitle = null;
										System.out.println("  Search the book by the Book_Title :");
										do {
											try {
												btitle = scanner.next();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookBean bean6 = new BookBean();
										bean6.setAuthor(btitle);
										List<BookBean> booktitle = service1.searchBookByTitle(btitle);
										for (BookBean bookBean : booktitle) {	
											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available with this title.");
											}
										}
										break;

									case 8:
										LinkedList<BookBean> info1 = service1.getBooksInfo();
										for (BookBean bookBean : info1) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------------");
											} else {
												System.out.println("Books info is not present");
											}
										}
										break;

									case 9:

										int issueId = 0;
										System.out.println("Enter the Book-Id:");
										do {
											try {
												issueId = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										int userId = 0;
										System.out.println("Enter the User-Id:");
										do {
											try {
												userId = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);
										boolean check4=service1.issueBook(issueId,userId);
										if(check4) {
											System.out.println("-----------------------------------------------");
											System.out.println("Book Issued");
										}else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book not issued");
										}
										break;
									case 10:
										System.out.println("*****Users are*****");
										try {
											List<UsersBean> users = service1.showUsers();
											for (UsersBean Bean : users) {	
												if (Bean != null) {
													System.out.println("-----------------------------------------------");
													System.out.println("User_Id is-->"+Bean.getId());
													System.out.println("First_Name is-->"+Bean.getName());
													System.out.println("Email_Id is-->"+Bean.getEmail());
													System.out.println("Password is-->"+Bean.getPassword());
													System.out.println("Mobile_No is-->"+Bean.getMobile());
													System.out.println("User's_Role is-->"+Bean.getRole());
												} else {
													System.out.println("-----------------------------------------------");
													System.out.println("No Users are present");
												}
											}
										}catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 11:
										System.out.println(" Requests received are:");
										try {
											List<RequestBean> requests = service1.showRequest();
											for (RequestBean requestBean : requests) {	
												if (requestBean != null) {
													System.out.println("-----------------------------------------------");
													System.out.println("User_Id is-->"+requestBean.getUsers().getId());
													System.out.println("User_Name is-->"+requestBean.getName());
													System.out.println("Book_Id is-->"+requestBean.getBooks().getBId());
													System.out.println("BookName is-->"+requestBean.getBookName());
												} else {
													System.out.println("-----------------------------------------------");
													System.out.println("No Requests are received");
												}
											}
										}catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;

									case 12:

										int user_Id = 0;
										System.out.println("Enter the User-Id:");
										do {
											try {
												user_Id = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										try {
											List<Integer> uid = service1.bookHistoryDetails(user_Id);
											for (Integer issueDetails : uid) {
												if(issueDetails != null) {
													System.out.println("-----------------------------------------------");
													System.out.println("No of books Borrowed :"+issueDetails);
												} else {
													System.out.println("-----------------------------------------------");
													System.out.println("Respective user hasn't borrowed any books");
												}
											}
										}catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;

									case 13:
										doReg();

									default:
										System.out.println("Invalid Choice");
										break;
									}
								}   catch (InputMismatchException ex)   {
									System.out.println("Incorrect entry. Please input only a positive integer.");
									scanner.nextLine();
								}
							}while(true);
						}
						else if(loginInfo.getRole().equals("student")) {
							do {
								try {
									System.out.println("------------------------------------");
									System.out.println("Press 1 to Get All the Book-Ids");
									System.out.println("Press 2 to Search Book by Book-Id");
									System.out.println("Press 3 to Search Book by Author");
									System.out.println("Press 4 to Search Book by Title");
									System.out.println("Press 5 to Get All the Books Info");
									System.out.println("Press 6 to Request Book");
									System.out.println("Press 7 to View the Books Borrowed");
									System.out.println("Press 8 to Return Book");
									System.out.println("Press 9 to Main");
									System.out.println("------------------------------------");

									int choice2 = scanner.nextInt();
									switch (choice2) {
									case 1:
										LinkedList<BookBean> info = service1.getBookIds();
										for (BookBean bookBean : info) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
											} else {
												System.out.println("Books Ids is not present");
											}
										}
										break;
									case 2:

										int id = 0;
										System.out.println("Search the book by the Book-Id:");
										do {
											try {
												id = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookBean bean4 = new BookBean();
										bean4.setBId(id);
										List<BookBean> bookid = service1.searchBookById(id);
										for (BookBean bookBean : bookid) {

											if (bookBean != null) {
												System.out.println("----------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("----------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 3:

										String author = null;
										System.out.println("Search the book by the Author Name:");
										do {
											try {
												author = scanner.next();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);
										BookBean bean2 = new BookBean();
										bean2.setAuthor(author);
										List<BookBean> bookauthor = service1.searchBookByAuthor(author);
										for (BookBean bookBean : bookauthor) {

											if (bookBean != null) {
												System.out.println("---------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("---------------------------------------");
											} else {
												System.out.println("No books are available written by this author");
											}
										}
										break;
									case 4:

										String btitle = null;
										System.out.println("  Search the book by the Book_Title :");
										do {
											try {
												btitle = scanner.next();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										BookBean bean3 = new BookBean();
										bean3.setAuthor(btitle);
										List<BookBean> booktitle = service1.searchBookByTitle(btitle);
										for (BookBean bookBean : booktitle) {	
											if (bookBean != null) {
												System.out.println("---------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("---------------------------------------");
											} else {
												System.out.println("No books are available with this title.");
											}
										}
										break;
									case 5:
										LinkedList<BookBean> info1 = service1.getBooksInfo();
										for (BookBean bookBean : info1) {

											if (bookBean != null) {
												System.out.println("---------------------------------------");
												System.out.println("Book_Id is-->"+bookBean.getBId());
												System.out.println("Book_Name is-->"+bookBean.getBookName());
												System.out.println("Book_Author is-->"+bookBean.getAuthor());
												System.out.println("Book_PublisherName is-->"+bookBean.getPublisher());
												System.out.println("Book_Category is-->"+bookBean.getCategory());
												//System.out.println("No_Of_Copies are-->"+bookBean.getCopies());
												System.out.println("---------------------------------------");
											} else {
												System.out.println("Books info is not presernt");
											}
										}
										break;
									case 6:

										int reqBookId = 0;
										System.out.println("Enter the Book-Id:");
										do {
											try {
												reqBookId = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);


										int reqUserId = 0;
										System.out.println("Enter User-Id:");
										do {
											try {
												reqUserId = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										boolean requested = service1.request(reqUserId,reqBookId);
										if (requested != false) {
											System.out.println("-----------------------------------------------");
											System.out.println("Book is Requested");
										} else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book is not Requested");
										}	
										break;
									case 7:

										int user_Id = 0;
										System.out.println("Enter User-Id:");
										do {
											try {
												user_Id = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);
										
										try {
											if (loginInfo.getId()==user_Id) {
												List<BorrowedBooks> borrowedBookList = service1.borrowedBook(user_Id);
												for (BorrowedBooks bookBean : borrowedBookList) {

													if (bookBean != null) {
														System.out.println("-----------------------------------------------");
														System.out.println("User_Id is-->"+bookBean.getUsers().getId());
														System.out.println("Book_Id is-->"+bookBean.getBooks().getBId());
														System.out.println("Email Id is-->"+bookBean.getEmail());
													} else {
														System.out.println("-----------------------------------------------");
														System.out.println("No books are borrowed by the user");
													}
												}
											} else {
												System.out.println("Incorrect user_Id");
											}
										} catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;
									case 8:

										System.out.println("*****Returning a Book*****");

										int returnId = 0;
										System.out.println("Enter the Book-Id:");
										do {
											try {
												returnId = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);


										int userId = 0;
										System.out.println("Enter User-Id:");
										do {
											try {
												userId = scanner.nextInt();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);

										String status = null;
										System.out.println("Enter the status of the book :");
										do {
											try {
												status = scanner.next();
												flag = true ;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											}  catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											} 
										} while (!flag);
										try {
											if(loginInfo.getId()==userId) {
												boolean returned = service1.returnBook(returnId,userId,status);
												if (returned != false) {
													System.out.println("-----------------------------------------------");
													System.out.println("Book is Returned");
												} else {
													System.out.println("-----------------------------------------------");
													System.out.println("Book is not Returned");
												}	
											} else {
												System.out.println("Invalid userId");
											}
										} catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;

									case 9:
										doReg();
									default:
										break;
									}
								}   catch (InputMismatchException ex)   {
									System.out.println("Incorrect entry. Please input only a positive integer.");
									scanner.nextLine();
								}
							} while(true);
						}

					} catch(Exception e) {
						System.out.println("Invalid Credentials");
						System.out.println("Try login again,Press 2 to login");
						//scanner.nextLine();
					}
					break;
				case 3 :
					System.out.println("EXIT");
					System.out.println(0);
				default:
					break;
				}
			} catch (InputMismatchException ex)   {
				System.out.println("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}

		} while(loginStatus);
		//	}while(true);

	}
}
