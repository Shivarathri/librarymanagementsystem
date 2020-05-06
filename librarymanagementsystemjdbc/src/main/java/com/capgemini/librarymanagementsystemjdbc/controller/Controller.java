package com.capgemini.librarymanagementsystemjdbc.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.IssueBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryFactory;
import com.capgemini.librarymanagementsystemjdbc.service.UsersService;
import com.capgemini.librarymanagementsystemjdbc.validation.Validation;

public class Controller {
	public static void main(String[] args) {
		doReg();
	}

	@SuppressWarnings("resource")
	public static void doReg() {
		boolean flag = false;

		int regId = 0;
		String regFirstName = null;
		String regLastName = null;
		String regMobile = null;
		String regEmail = null;
		String regPassword = null;
		String regRole = null;

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

			UsersService service1 = LibraryFactory.getUsersService();

			try {
				int choice = scanner.nextInt();
				switch (choice) {
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
							scanner.nextLine();
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter First Name :");
							regFirstName = scanner.next();
							validation.validatedName(regFirstName);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Name should contains only Alphabates");
							scanner.nextLine();
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					
					do {
						try {
							System.out.println("Enter Last Name :");
							regLastName = scanner.next();
							validation.validatedName(regLastName);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Name should contains only Alphabates");
							scanner.nextLine();
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
							scanner.nextLine();
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
							scanner.nextLine();
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
							scanner.nextLine();
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					do {
						try {
							System.out.println("Enter the Role :");
							regRole = scanner.next();
							validation.validatedRole(regRole);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Role should contains only alphabates");
							scanner.nextLine();
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					UsersBean ai = new UsersBean();
					ai.setuId(regId);
					ai.setFirstName(regFirstName);
					ai.setLastName(regLastName);
					ai.setEmail(regEmail);
					ai.setPassword(regPassword);
					ai.setMobile(regMobile);
					ai.setRole(regRole);
					boolean check = service1.register(ai);
					if (check) {
						System.out.println("Registered");
					} else {
						System.err.println("Already user is registered");
					}
					break;
				case 2:

					String email = null;
					do {
						try {
							System.out.println("Enter Email for login :");
							email = scanner.next();
							validation.validatedEmail(email);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Email should be proper ");
							scanner.nextLine();
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);

					String password = null;
					do {
						try {
							System.out.println("Enter Password :");
							password = scanner.next();
							validation.validatedPassword(password);
							flag = true;
						} catch (InputMismatchException e) {
							flag = false;
							System.err.println("Enter correct Password ");
							scanner.nextLine();
						} catch (LMSException e) {
							flag = false;
							System.err.println(e.getMessage());
						}
					} while (!flag);
					
					UsersBean loginInfo = service1.login(email, password);
					try {

						if (loginInfo.getEmail().equals(email) &&
							loginInfo.getPassword().equals(password)) {

								System.out.println("Logged In");
						}

						if (loginInfo.getRole().equals("admin")) {
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
												addBookId = scanner.nextInt();
												validation.validatedBookId(addBookId);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Id should contains only digits");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Book Name :");
												addBookName = scanner.next();
												validation.validatedName(addBookName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Book-Name should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Author Name :");
												addBookAuthorName = scanner.next();
												validation.validatedName(addBookAuthorName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Author-Name should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Category Name :");
												addBookCategory = scanner.next();
												validation.validatedName(addBookCategory);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Category-Name should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter Publisher Name :");
												addBookPublisher = scanner.next();
												validation.validatedName(addBookPublisher);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Publsher-Name should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bi = new BookBean();
										bi.setbId(addBookId);
										bi.setBookName(addBookName);
										bi.setAuthor(addBookAuthorName);
										bi.setCategory(addBookCategory);
										bi.setPublisher(addBookPublisher);
										boolean check2 = service1.addBook(bi);
										if (check2) {
											System.out.println("Added Book");
										} else {
											System.out.println("Book not added");
										}
										break;
									case 2:
										do {
											try {
												System.out.println("Enter the updated id :");
												updateBookId = scanner.nextInt();
												validation.validatedBookId(updateBookId);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error in the input,try again.");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookName to be Updated :");
												updateBookName = scanner.next();
												validation.validatedName(updateBookName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Book-Name should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookAuthor to be Updtaed :");
												updateBookAuthorName = scanner.next();
												validation.validatedName(updateBookAuthorName);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Book-AuthorName should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookCategory to be Updtaed :");
												updateBookCategory = scanner.next();
												validation.validatedName(updateBookCategory);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Book-Category should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										do {
											try {
												System.out.println("Enter BookPublisher to be Updtaed :");
												updateBookPublisher = scanner.next();
												validation.validatedName(updateBookPublisher);
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Book-publisher should contains only Alphabates");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bean2 = new BookBean();
										bean2.setbId(updateBookId);
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
												removeId = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										boolean check3 = service1.removeBook(removeId);
										if (check3) {
											System.out.println("Removed Book");
										} else {
											System.out.println("Book not removed");
										}
										break;

									case 4:
										LinkedList<BookBean> info = service1.getBookIds();
										for (BookBean bookBean : info) {

											if (bookBean != null) {
												System.out.println("-------------------------------------");
												System.out.println("Book_Id is-->" + bookBean.getbId());
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bean4 = new BookBean();
										bean4.setbId(id);
										List<BookBean> bookid = service1.searchBookById(id);
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));

										for (BookBean bookBean : bookid) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));

												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->"+bookBean.getBid());
												 * System.out.println("Book_Name is-->"+bookBean.getBname());
												 * System.out.println("Book_Author is-->"+bookBean.getBauthor()) ;
												 * System.out.println("Book_Category is-->"+bookBean.getCategory ());
												 * System.out.println("Book_PublisherName is-->"+bookBean.
												 * getPublishername());
												 */
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bean5 = new BookBean();
										bean5.setAuthor(author);
										List<BookBean> bookauthor = service1.searchBookByAuthor(author);
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));

										for (BookBean bookBean : bookauthor) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));

												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->"+bookBean.getBid());
												 * System.out.println("Book_Name is-->"+bookBean.getBname());
												 * System.out.println("Book_Author is-->"+bookBean.getBauthor()) ;
												 * System.out.println("Book_Category is-->"+bookBean.getCategory ());
												 * System.out.println("Book_PublisherName is-->"+bookBean.
												 * getPublishername());
												 */
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bean6 = new BookBean();
										bean6.setAuthor(btitle);
										List<BookBean> booktitle = service1.searchBookByTitle(btitle);
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));

										for (BookBean bookBean : booktitle) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));

												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->"+bookBean.getBid());
												 * System.out.println("Book_Name is-->"+bookBean.getBname());
												 * System.out.println("Book_Author is-->"+bookBean.getBauthor()) ;
												 * System.out.println("Book_Category is-->"+bookBean.getCategory ());
												 * System.out.println("Book_PublisherName is-->"+bookBean.
												 * getPublishername());
												 */
											} else {
												System.out.println("No books are available with this title.");
											}
										}
										break;

									case 8:
										LinkedList<BookBean> info1 = service1.getBooksInfo();
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));
										for (BookBean bookBean : info1) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));
												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->" + bookBean.getBid());
												 * System.out.println("Book_Name is-->" + bookBean.getBname());
												 * System.out.println("Book_Author is-->" + bookBean.getBauthor());
												 * System.out.println("Book_Category is-->" + bookBean.getCategory());
												 * System.out.println( "Book_PublisherName is-->" +
												 * bookBean.getPublishername());
												 */
												System.out.println(
														"----------------------------------------------------------");
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										int userId = 0;
										System.out.println("Enter the User-Id:");
										do {
											try {
												userId = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);
										boolean check4 = service1.issueBook(issueId, userId);
										if (check4) {
											System.out.println("-----------------------------------------------");
											System.out.println("Book Issued");
										} else {
											System.out.println("-----------------------------------------------");
											System.out.println("Book not issued");
										}
										break;
									case 10:
										try {
											System.out.println("--------Users of Library are------------");

											List<UsersBean> usersInfo = service1.showUsers();

											System.out.println(String.format("%-10s %-15s %-15s %-15s %-10s %-10s %s",
													"UserId", "FirstName", "LastName", "Email", "Password", "Mobile",
													"Role"));

											for (UsersBean bean : usersInfo) {
												if (bean != null) {

													System.out.println(String.format(
															"%-10s %-15s %-15s %-15s %-10s %-10s %s", bean.getuId(),
															bean.getFirstName(), bean.getLastName(), bean.getEmail(),
															bean.getPassword(), bean.getMobile(), bean.getRole()));
													/*
													 * System.out.println(
													 * "-----------------------------------------------");
													 * System.out.println("User_Id is-->" + bean.getUId());
													 * System.out.println("User Name is-->" + bean.getName());
													 * System.out.println("Email_Id is-->" + bean.getEmail());
													 * System.out.println("Password is-->" + bean.getPassword());
													 * System.out.println("Mobile_No is-->" + bean.getMobile());
													 * System.out.println("User's_Role is-->" + bean.getRole());
													 */
													System.out.println(
															"-----------------------------------------------------");
												} else {
													System.out.println("No user are there");
												}
											}
										} catch (Exception e) {
											System.out.println("No Users present in library");
										}
										break;
									case 11:
										try {
											System.out.println("*****Requests for Books are *****");
											System.out.println("-------------------------------------");
											List<RequestBookDetailsBean> requestInfos = service1.showRequest();
											System.out.println(String.format("%-5s %s", "BookId", "UserId"));
											for (RequestBookDetailsBean infos : requestInfos) {
												System.out.println("---------------------------------------");
												System.out.println(
														String.format("%-5s %s", infos.getbId(), infos.getuId()));
												/*
												 * System.out.println("Book id ---------- " + infos.getbId());
												 * System.out.println("User id----------- " + infos.getuId());
												 * System.out.println("---------------------------------------");
												 */

											}
										} catch (Exception e) {
											System.out.println("no books present in library");
										}

									case 12:

										int user_Id = 0;
										System.out.println("Enter the User-Id:");
										do {
											try {
												user_Id = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										List<IssueBookDetailsBean> uid = service1.bookHistoryDetails(user_Id);
										for (IssueBookDetailsBean issueDetails : uid) {
											if (issueDetails != null) {
												System.out.println("-----------------------------------------------");
												System.out.println("No of books Borrowed :" + issueDetails.getUserId());
											} else {
												System.out.println("-----------------------------------------------");
												System.out.println("Respective user hasn't borrowed any books");
											}
										}
										break;

									case 13:
										doReg();

									default:
										System.err.println("Invalid Choice.Please choose a number in between 1 to 13");
										break;
									}
								} catch (InputMismatchException ex) {
									System.err.println("Incorrect entry. Please input only a positive integer.");
									scanner.nextLine();
								}
							} while (true);
						} else if (loginInfo.getRole().equals("student")) {
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
												System.out.println("Book_Id is-->" + bookBean.getbId());
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bean4 = new BookBean();
										bean4.setbId(id);
										List<BookBean> bookid = service1.searchBookById(id);
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));

										for (BookBean bookBean : bookid) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));

												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->"+bookBean.getBid());
												 * System.out.println("Book_Name is-->"+bookBean.getBname());
												 * System.out.println("Book_Author is-->"+bookBean.getBauthor()) ;
												 * System.out.println("Book_Category is-->"+bookBean.getCategory ());
												 * System.out.println("Book_PublisherName is-->"+bookBean.
												 * getPublishername());
												 */
												System.out.println(
														"-----------------------------------------------------------------");
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);
										BookBean bean2 = new BookBean();
										bean2.setAuthor(author);
										List<BookBean> bookauthor = service1.searchBookByAuthor(author);
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));

										for (BookBean bookBean : bookauthor) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));

												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->"+bookBean.getBid());
												 * System.out.println("Book_Name is-->"+bookBean.getBname());
												 * System.out.println("Book_Author is-->"+bookBean.getBauthor()) ;
												 * System.out.println("Book_Category is-->"+bookBean.getCategory ());
												 * System.out.println("Book_PublisherName is-->"+bookBean.
												 * getPublishername());
												 */
												System.out.println(
														"-----------------------------------------------------------");
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										BookBean bean3 = new BookBean();
										bean3.setAuthor(btitle);
										List<BookBean> booktitle = service1.searchBookByTitle(btitle);
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));

										for (BookBean bookBean : booktitle) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));

												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->"+bookBean.getBid());
												 * System.out.println("Book_Name is-->"+bookBean.getBname());
												 * System.out.println("Book_Author is-->"+bookBean.getBauthor()) ;
												 * System.out.println("Book_Category is-->"+bookBean.getCategory ());
												 * System.out.println("Book_PublisherName is-->"+bookBean.
												 * getPublishername());
												 */
												System.out.println(
														"------------------------------------------------------------------");
											} else {
												System.out.println("No books are available with this title.");
											}
										}
										break;
									case 5:
										LinkedList<BookBean> info1 = service1.getBooksInfo();
										System.out.println(String.format("%-10s %-15s %-15s %-10s %s", "Book-Id",
												"Name", "Author", "Category", "Publisher"));
										for (BookBean bookBean : info1) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														bookBean.getbId(), bookBean.getBookName(), bookBean.getAuthor(),
														bookBean.getCategory(), bookBean.getPublisher()));
												/*
												 * System.out.println("-----------------------------------");
												 * System.out.println("Book_Id is-->" + bookBean.getBid());
												 * System.out.println("Book_Name is-->" + bookBean.getBname());
												 * System.out.println("Book_Author is-->" + bookBean.getBauthor());
												 * System.out.println("Book_Category is-->" + bookBean.getCategory());
												 * System.out.println( "Book_PublisherName is-->" +
												 * bookBean.getPublishername());
												 */
												System.out.println(
														"------------------------------------------------------------");
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
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										int reqUserId = 0;
										System.out.println("Enter User-Id:");
										do {
											try {
												reqUserId = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										try {
											if (loginInfo.getuId() == reqUserId) {
												boolean requested = service1.request(reqUserId, reqBookId);
												if (requested != false) {
													System.out
															.println("-----------------------------------------------");
													System.out.println("Book is Requested");
												} else {
													System.out
															.println("-----------------------------------------------");
													System.out.println("Book is not Requested");
												}
											} else {
												System.err.println("Enter the correct UserId");
											}
										} catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;

									case 7:

										int user_Id = 0;
										System.out.println("Enter User-Id:");
										do {
											try {
												user_Id = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);
										List<BorrowedBooksBean> borrowedBookList = service1.borrowedBook(user_Id);
										System.out
												.println(String.format("%-10s %-10s %s", "UserID", "BookId", "Email"));
										for (BorrowedBooksBean bookBean : borrowedBookList) {

											if (bookBean != null) {

												System.out.println(String.format("%-10s %-10s %s", bookBean.getuId(),
														bookBean.getbId(), bookBean.getEmail()));
												System.out.println(
														"------------------------------------------------------------");
												/*
												 * System.out.println("User_Id is-->" + bookBean.getuId());
												 * System.out.println("Book_Id is-->" + bookBean.getbId());
												 * System.out.println("Email Id is-->" + bookBean.getEmail());
												 */
											} else {
												System.out.println("-----------------------------------------------");
												System.out.println("No books are borrowed by the user");
											}
										}
										break;
									case 8:

										System.out.println("*****Returning a Book*****");

										int returnId = 0;
										System.out.println("Enter the Book-Id:");
										do {
											try {
												returnId = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										int userId = 0;
										System.out.println("Enter User-Id:");
										do {
											try {
												userId = scanner.nextInt();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);

										String status = null;
										System.out.println("Enter the status of the book :");
										do {
											try {
												status = scanner.next();
												flag = true;
											} catch (InputMismatchException e) {
												flag = false;
												System.err.println("Error on the input, try again. ");
												scanner.nextLine();
											} catch (LMSException e) {
												flag = false;
												System.err.println(e.getMessage());
											}
										} while (!flag);
										try {
											if (loginInfo.getuId() == userId) {
												boolean returned = service1.returnBook(returnId, userId, status);
												if (returned != false) {
													System.out
															.println("-----------------------------------------------");
													System.out.println("Book is Returned");
												} else {
													System.out
															.println("-----------------------------------------------");
													System.out.println("Book is not Returned");
												}
											} else {
												System.err.println("Invalid userId");
											}
										} catch (LMSException e) {
											System.err.println(e.getMessage());
										}
										break;

									case 9:
										doReg();
									default:
										System.err.println("Choose a valid number from above mentioned list");
										break;
									}
								} catch (InputMismatchException ex) {
									System.err.println("Incorrect entry. Please input only a positive integer.");
									scanner.nextLine();
								}
							} while (true);
						}

					} catch (Exception e) {
						System.err.println("Invalid Credentials");
						System.err.println("Try login again,Press 2 to login");
						// scanner.nextLine();
					}
					break;
				case 3:
					doReg();
				default:
					System.err.println("Invalid Choice.Please choose a choise from above");
					break;
				}
			} catch (InputMismatchException ex) {
				System.err.println("Incorrect entry. Please input only a positive integer.");
				scanner.nextLine();
			}

		} while (loginStatus);

	}
}
