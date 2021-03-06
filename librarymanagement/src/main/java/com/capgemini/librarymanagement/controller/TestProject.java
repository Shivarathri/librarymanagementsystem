package com.capgemini.librarymanagement.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagement.db.DB;
import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.RequestBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.exception.AdminException;
import com.capgemini.librarymanagement.exception.ValidationException;
import com.capgemini.librarymanagement.factory.AdminFactory;
import com.capgemini.librarymanagement.factory.StudentFactory;
import com.capgemini.librarymanagement.service.AdminServiceDAO;
import com.capgemini.librarymanagement.service.StudentServiceDAO;
import com.capgemini.librarymanagement.validation.ValidationAdminStudent;

public class TestProject {
	public static void main(String[] args) {
		doReg();
	}

	@SuppressWarnings({ "unused", "resource", "static-access" })
	public static void doReg() {

		boolean flag = false;

		int regId = 0;
		String regName = null;
		String regMobile = null;
		String regEmail = null;
		String regPassword = null;

		int regId1 = 0;
		String regName1 = null;
		String regMobile1 = null;
		String regEmail1 = null;
		String regPassword1 = null;

		int bookId = 0;
		String bookAuthor = null;
		String bookName = null;
		String bookCategory = null;
		String bookPublisherName = null;
		String bookIssuedate = null;
		String bookReturndate = null;

		DB dataBase = new DB();
		dataBase.addDummyDetails();

		
		ValidationAdminStudent validation = new ValidationAdminStudent();

		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("----------WELCOME TO LIBRARY-----------");
				System.out.println("Press 1 to Admin Page");
				System.out.println("Press 2 to Student Page");
				System.out.println("---------------------------------------");

				int i = scanner.nextInt();
				switch (i) {
				case 1:
					AdminServiceDAO service = AdminFactory.getAdminServiceDAO();
					do {
						try {
							System.out.println("-----------------------------------");
							System.out.println("Press 1 to Admin Register");
							System.out.println("Press 2 to Login");
							System.out.println("Press 3 to exit");
							System.out.println("-----------------------------------");
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
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Name :");
										regName = scanner.next();
										validation.validatedName(regName);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Name should contains only Alphabates");
										scanner.nextLine();
									} catch (ValidationException e) {
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
									} catch (ValidationException e) {
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
									} catch (ValidationException e) {
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
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								AdminBean bean = new AdminBean();
								bean.setAid(regId);
								bean.setAname(regName);
								bean.setPhone(regMobile);
								bean.setEmail(regEmail);
								bean.setPassword(regPassword);

								boolean check = service.register(bean);
								if (check) {
									System.out.println("Registered");
								} else {
									System.err.println("Email already exist");
								}

								break;

							case 2:

								do {
									System.out.println("Enter Email :");
									String email = scanner.next();

									System.out.println("Enter Password :");
									String password = scanner.next();
									try {
										AdminBean authBean = service.auth(email, password);
										flag = true;
									} catch (Exception e) {
										flag = false;
										System.err.println(e.getMessage());
										// System.err.println("Please Re-enter the credintials");
									}

								} while (!flag);

								try {

									System.out.println("Logged in");

									do {
										try {
											System.out.println("-----------------------------------");
											System.out.println("Press 1 to Add Books");
											System.out.println("Press 2 to Search the Book by Author");
											System.out.println("Press 3 to Search the Book by Title");
											System.out.println("Press 4 to Search the Book by Category");
											System.out.println("Press 5 to remove the Books");
											System.out.println("Press 6 to Get All the Book Id's");
											System.out.println("Press 7 to Get  All The Books Info");
											System.out.println("Press 8 to Book Issue");
											System.out.println("Press 9 to Show Users");
											System.out.println("Press 10 to Show Requests");
											System.out.println("Press 11 Receive Returned Book");
											System.out.println("Press 12 to main");
											System.out.println("-----------------------------------");
											int choice1 = scanner.nextInt();
											switch (choice1) {
											case 1:

												do {
													try {
														System.out.println("Enter Book-ID :");
														bookId = scanner.nextInt();
														validation.validatedBookId(bookId);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Id should contains only digits");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												do {
													try {
														System.out.println("Enter Book Name :");
														bookName = scanner.next();
														validation.validatedName(bookName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Book-Name should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												do {
													try {
														System.out.println("Enter Author :");
														bookAuthor = scanner.next();
														validation.validatedName(bookAuthor);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err
																.println("Author Name should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												do {
													try {
														System.out.println("Enter Category :");
														bookCategory = scanner.next();
														validation.validatedName(bookCategory);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println(
																"Book-Category should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												do {
													try {
														System.out.println("Enter PublisherName :");
														bookPublisherName = scanner.next();
														validation.validatedName(bookPublisherName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println(
																"Book-PublisherName should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean1 = new BookBean();
												bean1.setBid(bookId);
												bean1.setBname(bookName);
												bean1.setCategory(bookCategory);
												bean1.setBauthor(bookAuthor);
												bean1.setPublishername(bookPublisherName);
												// bean1.setIssuedate(bookIssuedate);
												boolean check2 = service.addBook(bean1);
												if (check2) {
													System.out.println("Book Added");
												} else {
													System.out.println("Book already exist");
												}
												break;

											case 2:

												do {
													try {
														System.out.println("Search the book by the Author Name:");
														bookAuthor = scanner.next();
														validation.validatedName(bookAuthor);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println(
																"Book-PublisherName should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean3 = new BookBean();
												bean3.setBauthor(bookAuthor);
												List<BookBean> bookauthor = service.searchBookAuthor(bookAuthor);
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));

												for (BookBean bookBean : bookauthor) {

													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));

														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->"+bookBean.getBid());
														 * System.out.println("Book_Name is-->"+bookBean.getBname());
														 * System.out.println("Book_Author is-->"+bookBean.getBauthor())
														 * ;
														 * System.out.println("Book_Category is-->"+bookBean.getCategory
														 * ()); System.out.println("Book_PublisherName is-->"+bookBean.
														 * getPublishername());
														 */
													} else {
														System.out.println(
																"No books are available written by this author");
													}
												}
												break;
											case 3:

												do {
													try {
														System.out.println("  Search the book by the Book-Title :");
														bookName = scanner.next();
														validation.validatedName(bookName);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println(
																"Book-PublisherName should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean4 = new BookBean();
												bean4.setBauthor(bookName);
												List<BookBean> booktitle = service.searchBookTitle(bookName);
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : booktitle) {

													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));
														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
											case 4:
												String category = null;
												do {
													try {
														System.out.println("Search the book by the Book_Category :");
														category = scanner.next();
														validation.validatedName(category);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println(
																"Book-Category should contains only Alphabates");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean5 = new BookBean();
												bean5.setBauthor(category);
												List<BookBean> bookIds = service.searchBookType(category);
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : bookIds) {
													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));

														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out
																.println("No books are available with this Category.");
													}
												}
												break;
											case 5:

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
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												if (removeId == 0) {
													System.out.println("Enter the Valid Book_Id");
												} else {
													BookBean bean6 = new BookBean();
													bean6.setBid(removeId);
													boolean remove = service.removeBook(removeId);
													if (remove) {
														System.out.println("The Book is removed");
													} else {
														System.out.println("The Book is not removed");
													}
												}
												break;
											case 6:
												List<Integer> ids = service.getBookIds();
												for (Integer integer : ids) {

													if (integer != null) {
														System.out.println(integer);
													} else {
														System.out.println("No Books Ids are available");
													}
												}
												break;
											case 7:
												List<BookBean> info = service.getBooksInfo();
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : info) {

													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));
														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out.println("Books info is not present");
													}
												}
												break;
											case 8:

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
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												int studentId = 0;
												System.out.println("Enter the Student-Id:");
												do {
													try {
														studentId = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												StudentBean userBean2 = new StudentBean();
												userBean2.setSid(studentId);
												BookBean bookBean2 = new BookBean();
												bookBean2.setBid(issueId);

												try {
													boolean isIssued = service.bookIssue(userBean2, bookBean2);
													if (isIssued) {
														System.out.println("Book Issued");
													} else {
														System.out.println("Book cannot be issued");
													}

												} catch (Exception e) {
													System.out.println("Invalid data request book cannot be issued");
												}
												break;
											case 9:
												try {
													System.out.println("*****Users of Library are*****");
													System.out.println("-------------------------------");

													List<StudentBean> userInfos = service.showUsers();
													System.out.println(String.format("%-10s %-15s %-20s %s", "User-Id",
															"UserName", "Email", "BooksBorrowed"));

													for (StudentBean infos : userInfos) {

														System.out.println(String.format("%-10s %-15s %-20s %s",
																infos.getSid(), infos.getSname(), infos.getEmail(),
																infos.getBooksBorrowed()));
														/*
														 * System.out.println("User id ---------- " + infos.getSid());
														 * System.out.println("User Name -------- " + infos.getSname());
														 * System.out.println("User Email------ " + infos.getEmail());
														 * System.out.println("User No Of Books Borrowed ------- " +
														 * infos.getBooksBorrowed());
														 */
													}
												} catch (Exception e) {
													System.out.println("No books present in library");
												}
												break;
											case 10:
												try {
													System.out.println("*****Requests for Books are*****");
													System.out.println("-------------------------------");

													List<RequestBean> requestInfos = service.showRequests();
													System.out.println(String.format("%-10s %-15s %-15s %-10s %-10s %s",
															"Book-Id", "Author", "User-Id", "UserName", "Issued",
															"Returned"));
													for (RequestBean info1 : requestInfos) {

														System.out.println(
																String.format("%-10s %-15s %-15s %-10s %-10s %s",
																		info1.getBookInfo().getBid(),
																		info1.getBookInfo().getBauthor(),
																		info1.getStudentInfo().getSid(),
																		info1.getStudentInfo().getSname(),
																		info1.isIssued(), info1.isReturned()));

														/*
														 * System.out.println( "Book id ---------- " +
														 * info1.getBookInfo().getBid()); System.out.println(
														 * "Book Name -------- " + info1.getBookInfo().getBauthor());
														 * System.out.println( "User id----------- " +
														 * info1.getStudentInfo().getSid()); System.out.println(
														 * "User Name -------- " + info1.getStudentInfo().getSname());
														 * System.out.println("Book Issued ------" + info1.isIssued());
														 * System.out.println("Book Returned------" +
														 * info1.isReturned());
														 */

													}
												} catch (Exception e) {
													System.out.println("no books present in library");
												}
												break;
											case 11:
												System.out.println("*****Receive Returned Book*****");
												System.out.println("-----------------------------------");
												int user1 = 0;
												System.out.println("Enter the Student-Id:");
												do {
													try {
														user1 = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												int book1 = 0;
												System.out.println("Enter the Book-Id:");
												do {
													try {
														book1 = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												StudentBean student = new StudentBean();
												BookBean book = new BookBean();
												student.setSid(user1);
												book.setBid(book1);
												boolean isReceive = service.isBookReceived(student, book);
												if (isReceive) {
													System.out.println(" Received Returned book");
												} else {
													System.out.println("Invalid ! Admin unable to receive");
												}
												break;
											case 12:
												doReg();
											default:
												System.err.println("Invalid Choice.Please choose a choice from above");
												break;
											}
										} catch (InputMismatchException ex) {

											System.err
													.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										} catch (AdminException e) {
											System.err.println(e.getMessage());
										}

									} while (true);
								} catch (AdminException e) {
									System.err.println(e.getMessage());
								}

							case 3:
								doReg();
								break;
							default:
								System.err.println("Invalid Choice.Choose a number in between 1 & 3");
								break;
							}
						} catch (InputMismatchException ex) {
							System.err.println(
									"Incorrect entry. Please provide only a positive integer...Choose a number in between 1 & 3");
							scanner.nextLine();
						}
					} while (true);

				case 2:
					StudentServiceDAO service1 = StudentFactory.getStudentServiceDAO();
					do {
						try {
							System.out.println("-----------------------------------");
							System.out.println("Press 1 to Student Register");
							System.out.println("Press 2 to Student Login");
							System.out.println("Press 3 to main");
							System.out.println("-----------------------------------");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:
								do {

									try {
										System.out.println("Enter ID :");
										regId1 = scanner.nextInt();
										validation.validatedId(regId1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Id should contains only digits");
										scanner.nextLine();
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}

								} while (!flag);

								do {
									try {
										System.out.println("Enter Name :");
										regName1 = scanner.next();
										validation.validatedName(regName1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Name should contains only Alphabates");
										scanner.nextLine();
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Mobile :");
										regMobile1 = scanner.next();
										validation.validatedMobile(regMobile1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Mobile Number  should contains only numbers");
										scanner.nextLine();
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Email :");
										regEmail1 = scanner.next();
										validation.validatedEmail(regEmail1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Email should be proper ");
										scanner.nextLine();
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										System.out.println("Enter Password :");
										regPassword1 = scanner.next();
										validation.validatedPassword(regPassword1);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										System.err.println("Enter correct Password ");
										scanner.nextLine();
									} catch (ValidationException e) {
										flag = false;
										System.err.println(e.getMessage());
									}
								} while (!flag);

								StudentBean bean1 = new StudentBean();
								bean1.setSid(regId1);
								bean1.setSname(regName1);
								bean1.setPhone(regMobile1);
								bean1.setEmail(regEmail1);
								bean1.setPassword(regPassword1);

								boolean check = service1.register(bean1);
								if (check) {
									System.out.println("Registered");
								} else {
									System.out.println("Email already exist");
								}
								break;
							case 2:
								do {
									System.out.println("Enter Email :");
									String email = scanner.next();

									System.out.println("Enter Password :");
									String password = scanner.next();
									try {
										StudentBean studentBean = service1.auth(email, password);
										flag = true;
									} catch (Exception e) {
										flag = false;
										System.err.println(e.getMessage());
										// System.err.println("Please Re-enter the credintials");
									}

								} while (!flag);

								try {

									System.out.println("Logged in");
									do {
										try {
											System.out.println("--------------------------------------------");
											System.out.println("Press 1 to Search the Book by Author");
											System.out.println("Press 2 to Search the Book by Title");
											System.out.println("Press 3 to Search the Book by category");
											System.out.println("Press 4 to Get the Book Id's");
											System.out.println("Press 5 to Get the Books Information");
											System.out.println("Press 6 to Request the Book");
											System.out.println("Press 7 to Return the Book");
											System.out.println("Press 8 to main");
											System.out.println("--------------------------------------------");
											int choice2 = scanner.nextInt();
											switch (choice2) {
											case 1:

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
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean2 = new BookBean();
												bean2.setBauthor(author);
												List<BookBean> bookauthor = service1.searchBookAuthor(author);
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : bookauthor) {

													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));
														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
											case 2:

												String btitle = null;
												System.out.println("Search the book by the Book_Title :");
												do {
													try {
														btitle = scanner.next();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean3 = new BookBean();
												bean3.setBauthor(btitle);
												List<BookBean> booktitle = service1.searchBookTitle(btitle);
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : booktitle) {

													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));
														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out.println("No books are available with this title.");
													}
												}
												break;
											case 3:
												String category = null;
												System.out.println("Search the book by the Book_Category :");
												do {
													try {
														category = scanner.next();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												BookBean bean4 = new BookBean();
												bean4.setCategory(category);
												;
												List<BookBean> bookIds = service1.searchBookType(category);
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : bookIds) {
													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));

														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out
																.println("No books are available with this Category.");
													}
												}
												break;
											case 4:
												List<Integer> ids = service1.getBookIds();
												for (Integer integer : ids) {

													if (integer != null) {
														System.out.println(integer);
													} else {
														System.out.println("No Books Ids are available");
													}
												}
												break;
											case 5:
												List<BookBean> info = service1.getBooksInfo();
												System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
														"Book-Id", "Name", "Author", "Category", "Publisher"));
												for (BookBean bookBean : info) {

													if (bookBean != null) {

														System.out.println(String.format("%-10s %-15s %-15s %-10s %s",
																bookBean.getBid(), bookBean.getBname(),
																bookBean.getBauthor(), bookBean.getCategory(),
																bookBean.getPublishername()));
														/*
														 * System.out.println("-----------------------------------");
														 * System.out.println("Book_Id is-->" + bookBean.getBid());
														 * System.out.println("Book_Name is-->" + bookBean.getBname());
														 * System.out.println("Book_Author is-->" +
														 * bookBean.getBauthor());
														 * System.out.println("Book_Category is-->" +
														 * bookBean.getCategory()); System.out.println(
														 * "Book_PublisherName is-->" + bookBean.getPublishername());
														 */
													} else {
														System.out.println("Books info is not present");
													}
												}
												break;
											case 6:

												int bId = 0;
												System.out.println("Enter the Book-Id:");
												do {
													try {
														bId = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);
												BookBean bookBean = new BookBean();
												bookBean.setBid(bId);

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
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);

												StudentBean userBean = new StudentBean();
												userBean.setSid(userId);

												try {
													RequestBean request = service1.bookRequest(userBean, bookBean);
													System.out.println("*****Request placed to admin*****");
													System.out.println(String.format("%-10s %-15s %-10s %s", "UserId",
															"Name", "BookId", "Book_Name"));

													System.out.println(String.format("%-10s %-15s %-10s %s",
															request.getStudentInfo().getSid(),
															request.getStudentInfo().getSname(),
															request.getBookInfo().getBid(),
															request.getBookInfo().getBname()));
													/*
													 * System.out.println( "User Id-----" +
													 * request.getStudentInfo().getSid()); System.out.println(
													 * "User name---" + request.getStudentInfo().getSname());
													 * System.out.println("Book Id-----" +
													 * request.getBookInfo().getBid()); System.out
													 * .println("Book Name---" + request.getBookInfo().getBname());
													 */
												} catch (Exception e) {

													System.out.println("Enter valid data or Invalid Request");
												}
												break;
											case 7:

												System.out.println("*****Returning a book*****");
												System.out.println("----------------------------");

												int user = 0;
												System.out.println("Enter User-Id:");
												do {
													try {
														user = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);
												StudentBean userBean7 = new StudentBean();
												userBean7.setSid(user);

												int book_id = 0;
												System.out.println("Enter the Book-Id:");
												do {
													try {
														book_id = scanner.nextInt();
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														System.err.println("Error on the input, try again. ");
														scanner.nextLine();
													} catch (ValidationException e) {
														flag = false;
														System.err.println(e.getMessage());
													}
												} while (!flag);
												BookBean bookBean7 = new BookBean();
												bookBean7.setBid(book_id);

												try {
													RequestBean requestInfo = service1.bookReturn(userBean7, bookBean7);
													System.out.println("----Book is Returning to Admin----");
													System.out.println("-----------------------------------");

													System.out.println(String.format("%-10s %-10s %s", "UserId",
															"BookId", "IsReturned"));

													System.out.println(String.format("%-10s %-10s %s",
															requestInfo.getStudentInfo().getSid(),
															requestInfo.getBookInfo().getBid(),
															requestInfo.isReturned()));
													/*
													 * System.out.println( "User Id ------" +
													 * requestInfo.getStudentInfo().getSid()); System.out.println(
													 * "Book Id ------" + requestInfo.getBookInfo().getBid());
													 * System.out.println("Is Returning --" + requestInfo.isReturned());
													 */

												} catch (Exception e) {
													System.err.println("Invalid Return");
												}

												break;
											case 8:
												doReg();
											default:
												System.err.println("Invalid Choice.Please choose a choice from above");
												break;
											}
										} catch (InputMismatchException ex) {

											System.err
													.println("Incorrect entry. Please input only a positive integer.");
											scanner.nextLine();
										}
									} while (true);
								} catch (Exception e) {
									System.err.println("Please enter a valid Credentials");
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
					} while (true);
				default:
					System.err.println("Invalid Choice. Please choose either 1 or 2");
					break;
				}

			} catch (InputMismatchException ex) {
				System.err.println("Incorrect entry. Please input only a positive integers 1 or 2");
				scanner.nextLine();
			}
		} while (true);

	}

}
