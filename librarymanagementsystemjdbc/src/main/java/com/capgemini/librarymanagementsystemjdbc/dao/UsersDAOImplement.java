package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemjdbc.dto.IssueBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestBookDetailsBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;

public class UsersDAOImplement implements UsersDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public boolean register(UsersBean user) {

		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?,?,?,?,?)");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setInt(1, user.getuId());
					pstmt.setString(2, user.getFirstName());
					pstmt.setString(3, user.getLastName());
					pstmt.setString(4, user.getEmail());
					pstmt.setString(5, user.getPassword());
					pstmt.setString(6, user.getMobile());
					pstmt.setString(7, user.getRole());
					int count = pstmt.executeUpdate();
					if (user.getEmail().isEmpty() && count == 0) {
						return false;
					} else {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public UsersBean login(String email, String password) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn
						.prepareStatement("select * from users where email=? and password=?");) {
					Class.forName(pro.getProperty("path"));

					pstmt.setString(1, email);
					pstmt.setString(2, password);

					try (ResultSet rs = pstmt.executeQuery();) {
						if (rs.next()) {
							UsersBean bean = new UsersBean();
							bean.setuId(rs.getInt("uId"));
							bean.setFirstName(rs.getString("firstName"));
							bean.setLastName(rs.getString("lastName"));
							bean.setEmail(rs.getString("email"));
							bean.setPassword(rs.getString("password"));
							bean.setMobile(rs.getString("mobile"));
							bean.setRole(rs.getString("role"));
							return bean;
						} else {
							return null;
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBook(BookBean book) {

		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("insert into bookbean values(?,?,?,?,?)");) {
					Class.forName(pro.getProperty("path"));

					pstmt.setInt(1, book.getbId());
					pstmt.setString(2, book.getBookName());
					pstmt.setString(3, book.getAuthor());
					pstmt.setString(4, book.getCategory());
					pstmt.setString(5, book.getPublisher());
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateBook(BookBean book) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("update bookbean set bookname=? where bid=?");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setInt(1, book.getbId());
					pstmt.setString(2, book.getBookName());
					pstmt.setString(3, book.getAuthor());
					pstmt.setString(4, book.getCategory());
					pstmt.setString(5, book.getPublisher());
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean removeBook(int bId) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("delete from bookbean where bid=?");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setInt(1, bId);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BookBean> getBookIds() {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (Statement stmt = (Statement) conn.createStatement();) {
					Class.forName(pro.getProperty("path"));

					try (ResultSet rs = stmt.executeQuery("select distinct bid from bookbean");) {
						LinkedList<BookBean> beans = new LinkedList<BookBean>();
						while (rs.next()) {
							BookBean bean = new BookBean();
							bean.setbId(rs.getInt("bId"));

							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookById(int bId) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("select * from bookbean where bid=?");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setInt(1, bId);
					try (ResultSet rs = pstmt.executeQuery();) {
						LinkedList<BookBean> beans = new LinkedList<BookBean>();

						while (rs.next()) {

							BookBean bean = new BookBean();
							bean.setbId(rs.getInt("bId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublisher(rs.getString("publisher"));
							beans.add(bean);

						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByTitle(String bookName) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("select * from bookbean where bookname=?");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setString(1, bookName);
					try (ResultSet rs = pstmt.executeQuery();) {
						LinkedList<BookBean> beans = new LinkedList<BookBean>();
						while (rs.next()) {
							BookBean bean = new BookBean();
							bean.setbId(rs.getInt("bId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublisher(rs.getString("publisher"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BookBean> searchBookByAuthor(String author) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("select * from bookbean where author=?");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setString(1, author);
					try (ResultSet rs = pstmt.executeQuery();) {
						LinkedList<BookBean> beans = new LinkedList<BookBean>();
						while (rs.next()) {
							BookBean bean = new BookBean();
							bean.setbId(rs.getInt("bId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublisher(rs.getString("publisher"));
							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BookBean> getBooksInfo() {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (Statement stmt = (Statement) conn.createStatement();) {
					Class.forName(pro.getProperty("path"));

					try (ResultSet rs = stmt.executeQuery("select * from bookbean");) {
						LinkedList<BookBean> beans = new LinkedList<BookBean>();
						while (rs.next()) {
							BookBean bean = new BookBean();
							bean.setbId(rs.getInt("bId"));
							bean.setBookName(rs.getString("bookName"));
							bean.setAuthor(rs.getString("author"));
							bean.setCategory(rs.getString("category"));
							bean.setPublisher(rs.getString("publisher"));

							beans.add(bean);
						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean request(int uId, int bId) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pst = conn.prepareStatement("select * from bookbean where bid=?");) {
					pst.setInt(1, bId);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						try (PreparedStatement pstmt = conn.prepareStatement(
								"select count(*) as uid from borrowed_books where uid=? and bid=? and email=(select email from users where uid=?)");) {
							pstmt.setInt(1, uId);
							pstmt.setInt(2, bId);
							pstmt.setInt(3, uId);
							rs = pstmt.executeQuery();
							if (rs.next()) {
								int isBookExists = rs.getInt("uId");
								if (isBookExists == 0) {
									try (PreparedStatement pstmt1 = conn.prepareStatement(
											"select count(*) as uid from book_issue_details where uid=?");) {
										pstmt1.setInt(1, uId);
										rs = pstmt1.executeQuery();
										if (rs.next()) {
											int noOfBooksBorrowed = rs.getInt("uId");
											if (noOfBooksBorrowed < 3) {
												try (PreparedStatement pstmt2 = conn.prepareStatement(
														"insert into request_details values(?,(select concat(firstname,'_',lastname) from users where uid=?)"
																+ "(select email from users where uid=?),?,(select bookname from bookbean where bid=?))");) {
													pstmt2.setInt(1, uId);
													pstmt2.setInt(2, uId);
													pstmt2.setInt(3, uId);
													pstmt2.setInt(4, bId);
													pstmt2.setInt(5, bId);
													int count = pstmt2.executeUpdate();
													if (count != 0) {
														return true;
													} else {
														return false;
													}
												}
											} else {
												throw new LMSException("no Of books limit has crossed");
											}
										} else {
											throw new LMSException("no of books limit has crossed");
										}
									}
								} else {
									throw new LMSException("You have already borrowed the requested book");
								}
							} else {
								throw new LMSException("You have already borrowed the requested book");
							}
						}

					} else {
						throw new LMSException("The book with requested id is not present");
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<RequestBookDetailsBean> showRequest() {
		try (FileInputStream fin = new FileInputStream("db.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/library_management_system";
			try (Connection conn = DriverManager.getConnection(dburl, "root", "root")) {
				String query = "select * from request_details;";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {

					try (ResultSet rs = pstmt.executeQuery(query);) {
						List<RequestBookDetailsBean> beans = new LinkedList<RequestBookDetailsBean>();
						while (rs.next()) {
							RequestBookDetailsBean book = new RequestBookDetailsBean();
							book.setuId(rs.getInt("uId"));
							book.setFullName(rs.getString("fullName"));
							book.setbId(rs.getInt("bId"));
							book.setBookName(rs.getString("bookName"));
							beans.add(book);
						}
						return beans;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// return false;
		}
		return null;
	}

	@Override
	public boolean issueBook(int bId, int uId) {

		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement(
						"select * from request_details where uid=? and bid=? and email=(select email from users where uid=?)")) {
					pstmt.setInt(1, uId);
					pstmt.setInt(2, bId);
					pstmt.setInt(3, uId);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						try (PreparedStatement pstmt1 = conn
								.prepareStatement("insert into book_issue_details values(?,?,?,?)");) {
							pstmt1.setInt(1, bId);
							pstmt1.setInt(2, uId);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Calendar cal = Calendar.getInstance();
							String issueDate = sdf.format(cal.getTime());
							pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
							cal.add(Calendar.DAY_OF_MONTH, 7);
							String returnDate = sdf.format(cal.getTime());
							pstmt1.setDate(4, java.sql.Date.valueOf(returnDate));
							int count = pstmt1.executeUpdate();
							if (count != 0) {
								try (PreparedStatement pstmt2 = conn.prepareStatement(
										"insert into borrowed_books values(?,?,(select email from users where uid=?))")) {
									pstmt2.setInt(1, uId);
									pstmt2.setInt(2, bId);
									pstmt2.setInt(3, uId);
									int isBorrowed = pstmt2.executeUpdate();
									if (isBorrowed != 0) {
										return true;
									} else {
										return false;
									}
								}
							} else {
								throw new LMSException("Book Not issued");
							}
						}
					} else {
						throw new LMSException("The respective user have not placed any request");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BorrowedBooksBean> borrowedBook(int uId) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn.prepareStatement("select * from borrowed_books where uid=?");) {
					pstmt.setInt(1, uId);
					rs = pstmt.executeQuery();
					LinkedList<BorrowedBooksBean> beans = new LinkedList<BorrowedBooksBean>();
					while (rs.next()) {
						BorrowedBooksBean listOfbooksBorrowed = new BorrowedBooksBean();
						listOfbooksBorrowed.setuId(rs.getInt("uId"));
						listOfbooksBorrowed.setbId(rs.getInt("bId"));
						listOfbooksBorrowed.setEmail(rs.getString("email"));
						beans.add(listOfbooksBorrowed);
					}
					return beans;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean returnBook(int bId, int uId, String status) {

		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			Class.forName(pro.getProperty("path"));
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn
						.prepareStatement("delete from book_issue_details where bid=? and uid=?");) {
					pstmt.setInt(1, bId);
					pstmt.setInt(2, uId);
					int count = pstmt.executeUpdate();
					if (count != 0) {
						try (PreparedStatement pstmt1 = conn
								.prepareStatement("delete from borrowed_books where bid=? and uid=?");) {
							pstmt1.setInt(1, bId);
							pstmt1.setInt(2, uId);
							int isReturned = pstmt1.executeUpdate();
							if (isReturned != 0) {
								return true;
							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<UsersBean> showUsers() {

		try (FileInputStream fin = new FileInputStream("db.properties")) {
			Properties pro = new Properties();
			pro.load(fin);

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/library_management_system";
			try (Connection conn = DriverManager.getConnection(dburl, "root", "root")) {
				String query = "select * from users";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					try (ResultSet rs = pstmt.executeQuery(query);) {
						List<UsersBean> usersList = new LinkedList<UsersBean>();
						while (rs.next()) {

							UsersBean user = new UsersBean();
							user.setuId(rs.getInt("uId"));
							user.setFirstName(rs.getString("firstName"));
							user.setLastName(rs.getString("lastName"));
							user.setEmail(rs.getString("email"));
							user.setMobile(rs.getString("mobile"));
							user.setRole(rs.getString("role"));
							usersList.add(user);
						}
						return usersList;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<IssueBookDetailsBean> bookHistoryDetails(int uId) {
		try (FileInputStream info = new FileInputStream("db.properties");) {
			Properties pro = new Properties();
			pro.load(info);
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);) {
				try (PreparedStatement pstmt = conn
						.prepareStatement("select count(*) as uid from book_issue_details where uid=?");) {
					Class.forName(pro.getProperty("path"));
					pstmt.setInt(1, uId);
					rs = pstmt.executeQuery();
					LinkedList<IssueBookDetailsBean> beans = new LinkedList<IssueBookDetailsBean>();
					while (rs.next()) {
						IssueBookDetailsBean issueDetails = new IssueBookDetailsBean();
						issueDetails.setUserId(rs.getInt("uId"));
						beans.add(issueDetails);
					}
					return beans;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
