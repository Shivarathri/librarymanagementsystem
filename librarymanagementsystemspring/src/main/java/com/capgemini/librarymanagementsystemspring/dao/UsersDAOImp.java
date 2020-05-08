package com.capgemini.librarymanagementsystemspring.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystemspring.dto.BookBean;
import com.capgemini.librarymanagementsystemspring.dto.BookIssueDetailsBean;
import com.capgemini.librarymanagementsystemspring.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemspring.dto.RequestBean;
import com.capgemini.librarymanagementsystemspring.dto.UsersBean;
import com.capgemini.librarymanagementsystemspring.exception.LmsException;

@Repository
public class UsersDAOImp implements UsersDAO {
	// EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	@PersistenceUnit
	private EntityManagerFactory factory;

	public boolean register(UsersBean info) {

		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		} catch (Exception e) {
			// TODO: handle exceptionentityClass
			e.printStackTrace();
			// throw new LmsException("User is already exists!");
			return false;
		}
		return isAdded;
	}

	public UsersBean auth(String email, String password) {

		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select u from UsersBean u where u.email=:email and u.password=:password";
			TypedQuery<UsersBean> query = manager.createQuery(jpql, UsersBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UsersBean bean = query.getSingleResult();
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();
			factory.close();
		}

	}

	public boolean addBook(BookBean book) {
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		} catch (LmsException e) {
			// TODO: handle exceptionentityClass
			System.err.println(e.getMessage());
			// throw new LmsException("Book already exists!");
		}
		return isAdded;
	}

	public List<BookBean> searchBookByTitle(String bookName) {

		List<BookBean> list = null;

		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bookName", bookName);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		// manager.close();
		// factory.close();
		return list;

	}

	public List<BookBean> searchBookByAuthor(String author) {

		List<BookBean> list = null;

		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.author=:author";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("author", author);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		// manager.close();
		// factory.close();
		return list;

	}

	public List<BookBean> searchBookById(int bId) {
		List<BookBean> list = null;

		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		// manager.close();
		// factory.close();
		return list;

	}

	public boolean updateBook(BookBean bean) {

		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, bean.getbId());
			record.setBookName(bean.getBookName());
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}
		/* finally { manager.close(); factory.close(); } */
	}

	public boolean removeBook(int bid) {

		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, bid);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} /*
			 * finally { manager.close(); factory.close(); }
			 */
	}

	@SuppressWarnings("unchecked")
	public List<BookBean> getBooksInfo() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select p from BookBean p";
		Query query = manager.createQuery(jpql);
		List<BookBean> record = query.getResultList();
		return record;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsersBean> showUsers() {
		List userBeans = null;
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("from UsersBean");
			userBeans = q.getResultList();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return userBeans;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RequestBean> showRequest() {

		List userBeans = null;
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("from RequestBean");
			userBeans = q.getResultList();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		/*
		 * manager.close(); factory.close();
		 */
		return userBeans;

	}

	@SuppressWarnings({ "rawtypes" })
	public boolean issueBook(int bId, int uId) {
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if (rs != null) {
				String jpql1 = "select r from RequestBean r where r.uId=:uId and r.bId=:bId";
				TypedQuery<RequestBean> query1 = manager.createQuery(jpql1, RequestBean.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				List<RequestBean> rs1 = query1.getResultList();
				if (!rs1.isEmpty() && rs1 != null) {
					transaction.begin();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					BookIssueDetailsBean issueBook = new BookIssueDetailsBean();
					issueBook.setuId(uId);
					issueBook.setbId(bId);
					issueBook.setIssueDate(java.sql.Date.valueOf(issueDate));
					issueBook.setReturnDate(java.sql.Date.valueOf(returnDate));
					manager.persist(issueBook);
					transaction.commit();
					if (!rs1.isEmpty() && rs1 != null) {
						transaction.begin();
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bId=:bId");
						bookName.setParameter("bId", bId);
						List book = bookName.getResultList();
						BorrowedBooksBean borrowedBooks = new BorrowedBooksBean();
						borrowedBooks.setuId(uId);
						borrowedBooks.setbId(bId);
						borrowedBooks.setBookName(book.get(0).toString());
						manager.persist(borrowedBooks);
						transaction.commit();
						return true;
					} else {
						throw new LmsException("Book Not issued");
					}
				} else {
					throw new LmsException("The respective user have not placed any request");
				}
			} else {
				throw new LmsException("There is no book exist with bookId" + bId);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} /*
			 * finally { manager.close(); factory.close(); }
			 */
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean request(int uId, int bId) {
		int count = 0;
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			List rs = query.getResultList();
			if (rs != null) {
				String jpql1 = "select b from BorrowedBooksBean b where b.uId=:uId and b.bId=:bId";
				TypedQuery<BorrowedBooksBean> query1 = (TypedQuery<BorrowedBooksBean>) manager.createQuery(jpql1,
						BorrowedBooksBean.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				List rs1 = query1.getResultList();
				if (rs1.isEmpty() || rs1 == null) {
					String jpql2 = "select b from BookIssueDetailsBean b where b.uId=:uId";
					TypedQuery<BookIssueDetailsBean> query2 = (TypedQuery<BookIssueDetailsBean>) manager
							.createQuery(jpql2, BookIssueDetailsBean.class);
					query2.setParameter("uId", uId);
					List<BookIssueDetailsBean> rs2 = query2.getResultList();
					for (BookIssueDetailsBean p : rs2) {
						noOfBooks = count++;
					}
					if (noOfBooks < 3) {
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bId=:bookId");
						bookName.setParameter("bookId", bId);
						List book = bookName.getResultList();
						Query email = manager.createQuery("select u.email from UsersBean u where u.uId=:user_Id");
						email.setParameter("user_Id", uId);
						List userEmail = email.getResultList();
						transaction.begin();
						RequestBean request = new RequestBean();
						request.setuId(uId);
						request.setbId(bId);
						request.setEmail(userEmail.get(0).toString());
						request.setBookName(book.get(0).toString());
						manager.persist(request);
						transaction.commit();
						return true;

					} else {
						throw new LmsException("You have crossed the book limit");
					}
				} else {
					throw new LmsException("You have already borrowed the requested book");
				}
			} else {
				throw new LmsException("The book with requested id is not present");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} /*
			 * finally { manager.close(); factory.close(); }
			 */
	}

	public List<BorrowedBooksBean> borrowedBook(int uId) {
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BorrowedBooksBean b where b.uId=:uId";
			TypedQuery<BorrowedBooksBean> query = manager.createQuery(jpql, BorrowedBooksBean.class);
			query.setParameter("uId", uId);
			List<BorrowedBooksBean> recordList = query.getResultList();
			return recordList;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();
			factory.close();
		}
	}

	public boolean returnBook(int bId, int uId, String status) {
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if (rs != null) {
				String jpql1 = "select b from BookIssueDetailsBean b where b.bId=:bId and b.uId=:uId ";
				TypedQuery<BookIssueDetailsBean> query1 = manager.createQuery(jpql1, BookIssueDetailsBean.class);
				query1.setParameter("bId", bId);
				query1.setParameter("uId", uId);
				BookIssueDetailsBean rs1 = query1.getSingleResult();
				if (rs1 != null) {
					Date issueDate = rs1.getIssueDate();
					Calendar cal = Calendar.getInstance();
					Date returnDate = cal.getTime();
					long difference = issueDate.getTime() - returnDate.getTime();
					float daysBetween = (difference / (1000 * 60 * 60 * 24));
					if (daysBetween > 7.0) {
						// transaction.begin();
						float fine = daysBetween * 5;
						System.out.println("The user has to pay the fine of the respective book of Rs:" + fine);
						if (status == "yes") {
							transaction.begin();
							manager.remove(rs1);
							transaction.commit();

							transaction.begin();
							String jpql3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
							Query query3 = manager.createQuery(jpql3);
							query3.setParameter("bId", bId);
							query3.setParameter("uId", uId);
							BorrowedBooksBean bbb = (BorrowedBooksBean) query3.getSingleResult();
							manager.remove(bbb);
							transaction.commit();

							transaction.begin();
							String jpql4 = "select r from RequestBean r where r.bId=:bId and r.uId=:uId";
							Query query4 = manager.createQuery(jpql4);
							query4.setParameter("bId", bId);
							query4.setParameter("uId", uId);
							RequestBean rdb = (RequestBean) query4.getSingleResult();
							manager.remove(rdb);
							transaction.commit();
							return true;
						} else {
							throw new LmsException("The User has to pay fine for delaying book return");
						}
					} else {
						transaction.begin();
						manager.remove(rs1);
						transaction.commit();

						transaction.begin();
						String jpql3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
						Query query3 = manager.createQuery(jpql3);
						query3.setParameter("bId", bId);
						query3.setParameter("uId", uId);
						BorrowedBooksBean bbb = (BorrowedBooksBean) query3.getSingleResult();
						manager.remove(bbb);
						transaction.commit();

						transaction.begin();
						String jpql4 = "select r from RequestBean r where r.bId=:bId and r.uId=:uId";
						Query query4 = manager.createQuery(jpql4);
						query4.setParameter("bId", bId);
						query4.setParameter("uId", uId);
						RequestBean rdb = (RequestBean) query4.getSingleResult();
						manager.remove(rdb);
						transaction.commit();
						return true;
					}

				} else {
					throw new LmsException("This respective user hasn't borrowed any book");
				}
			} else {
				throw new LmsException("book doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} /*
			 * finally { manager.close(); factory.close(); }
			 */
	}

	@SuppressWarnings("unused")
	public LinkedList<Integer> bookHistoryDetails(int uId) {
		int count = 0;
		// factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssueDetailsBean b";
		TypedQuery<BookIssueDetailsBean> query = manager.createQuery(jpql, BookIssueDetailsBean.class);
		List<BookIssueDetailsBean> recordList = query.getResultList();
		for (BookIssueDetailsBean p : recordList) {
			noOfBooks = count++;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(noOfBooks);
		manager.close();
		factory.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getBookIds() {
		List<Integer> bookBeans = null;
		try {
			// factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("select b.bId from BookBean b");
			bookBeans = q.getResultList();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		/*
		 * manager.close(); factory.close();
		 */
		return bookBeans;
	}

}
