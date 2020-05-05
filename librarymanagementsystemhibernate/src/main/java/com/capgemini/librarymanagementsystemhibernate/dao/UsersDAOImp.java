package com.capgemini.librarymanagementsystemhibernate.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueDetailsBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;

public class UsersDAOImp implements UsersDAO {
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;

	public boolean register(UsersBean info) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	public UsersBean auth(String email, String password) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
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
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "insert into BookBean (bId,bookName,author,category,publisher) values (:bId,:bookName,:author,:category,:publisher)";
			Query query = manager.createNativeQuery(jpql);
			query.setParameter("bId", book.getBId());
			query.setParameter("bookName", book.getBookName());
			query.setParameter("author", book.getAuthor());
			query.setParameter("category", book.getCategory());
			query.setParameter("publisher", book.getPublisher());
			int count = query.executeUpdate();
			transaction.commit();
			if (count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		} finally {
			manager.close();
			factory.close();
		}

	}

	public List<BookBean> searchBookByTitle(String bookName) {

		List<BookBean> list = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bookName", bookName);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		manager.close();
		factory.close();
		return list;

	}

	public List<BookBean> searchBookByAuthor(String author) {

		List<BookBean> list = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.author=:author";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("author", author);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		manager.close();
		factory.close();
		return list;

	}

	public List<BookBean> searchBookById(int bId) {
		List<BookBean> list = null;

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		manager.close();
		factory.close();
		return list;

	}

	public boolean updateBook(BookBean bean) {

		boolean isUpdated = false;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(bean);
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	public boolean removeBook(int bid) {

		boolean del = false;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, bid);
			if (manager.contains(record)) {
				del = true;
				manager.remove(record);
				System.out.println("Record removed");
			} else {
				del = false;
				System.out.println("record not found");
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		// return true;
		return del;
	}

	@SuppressWarnings("unchecked")
	public List<BookBean> getBooksInfo() {
		@SuppressWarnings("rawtypes")
		List bookBeans = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("from BookBean");
			bookBeans = q.getResultList();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return bookBeans;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsersBean> showUsers() {
		List userBeans = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
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
			factory = Persistence.createEntityManagerFactory("TestPersistence");
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
		manager.close();
		factory.close();
		return userBeans;

	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean issueBook(int bId, int uId) {
		BookIssueDetailsBean b = new BookIssueDetailsBean();
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookBean b where b.bId = :bbId");
			Query ss = q.setParameter("bbid", bId);
			List count = ss.getResultList();
			System.out.println(count);
			int S = count.size();
			if (S >= 1) {
				Query q1 = manager
						.createQuery("select r from RequestBean r where r.uId = :uId and r.CompositePK.bId = :bId");
				q1.setParameter("uId", uId);
				q1.setParameter("bId", bId);
				List count1 = q1.getResultList();
				int s = count1.size();
				System.out.println(s);
				if (s >= 1) {
					Query q2 = manager.createQuery("select count(uId) as uIdCount from BorrowedBooks b where uId=:uId");
					q2.setParameter("uId", uId);
					List count2 = q2.getResultList();
					int s1 = count2.size();
					if (s1 >= 1) {
						int noOfBooksBorrowed = count2.indexOf(0);
						if (noOfBooksBorrowed < 3) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							LocalDate date = LocalDate.now();
							Calendar c = Calendar.getInstance();
							c.setTime(new java.util.Date());
							c.add(Calendar.DATE, 15);
							String date1 = sdf.format(c.getTime());
							Query userEmail = manager.createQuery("select u.email from UsersBean u  where uId = :uId");
							userEmail.setParameter("uId", uId);
							List userEmail1 = userEmail.getResultList();
							Query q3 = manager.createNativeQuery(
									"insert into BookIssueDetails (uId,bId,issueDate,returnDate) values (? , ? , ? , ? ) ");
							q3.setParameter(1, uId);
							q3.setParameter(2, bId);
							q3.setParameter(3, date);
							q3.setParameter(4, date1);
							int count3 = q3.executeUpdate();
							if (count3 != 0) {
								Query userEmail4 = manager
										.createQuery("select u.email from UsersBean u where uId = :uId");
								userEmail4.setParameter("uId", uId);
								List userEmail44 = userEmail4.getResultList();
								Query q4 = manager
										.createNativeQuery("insert into BookIssueDetails (uId,bId) values (?,?)");
								q4.setParameter(1, uId);
								q4.setParameter(2, bId);
								q4.executeUpdate();

								Query q5 = manager.createQuery(
										"delete from RequestBean r where r.uId = :uId and r.CompositePK.bId = :bId");
								q5.setParameter("uId", uId);
								q5.setParameter("bId", bId);
								q5.executeUpdate();

								transaction.commit();
								return true;
							} else {
								System.out.println("Book Not issued");
							}

						} else {
							System.out.println("User Exceeds maximum limit");
						}

					} else {
						System.out.println("User can take atleast one book.");
					}
				} else {
					System.out.println("User can take atleast one book.");
				}

			} else {
				System.out.println("User can take atleast one book.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return false;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean request(int uId, int bId) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookBean b where b.bId = :bbId");
			Query s = q.setParameter("bbId", bId);
			List count = s.getResultList();
			int c = count.size();
			if (c != 0) {

				Query q1 = manager.createQuery("select u.name from UsersBean u where uId=:uId");
				q1.setParameter("uId", uId);
				List qq = q1.getResultList();
				Query q2 = manager.createQuery("select b.bookName from BookBean b where bId=:bId");
				q2.setParameter("bId", bId);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from UsersBean e where uId=:uId");
				q3.setParameter("uId", uId);
				List qq3 = q3.getResultList();
				Query req = manager
						.createNativeQuery("insert into RequestBean (bId,bookName,uId,name) values (?,?,?,?)");
				req.setParameter(1, bId);
				req.setParameter(2, qq1.get(0));
				req.setParameter(3, uId);
				req.setParameter(4, qq.get(0));

				req.executeUpdate();
				transaction.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return false;
	}

	public List<BorrowedBooksBean> borrowedBook(int uId) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BorrowedBooks b where b.uId=:uId";
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

	@SuppressWarnings({ "rawtypes", "unused" })
	public boolean returnBook(int bId, int uId, String status) {
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Query q = manager.createQuery("select b from BookBean b where b.bId = :bId");
			Query s = q.setParameter("bId", bId);
			List count = s.getResultList();
			int c = count.size();
			if (c != 0) {

				Query q1 = manager.createQuery("select u.name from UserBean u where u.uId=:uId");
				q1.setParameter("uId", uId);
				List qq = q1.getResultList();
				Query q2 = manager.createQuery("select b.bookName from BookBean b where b.bId=:bId");
				q2.setParameter("bId", bId);
				List qq1 = q2.getResultList();
				Query q3 = manager.createQuery("select e.email from UserBean e where e.uId=:uId");
				q3.setParameter("uId", uId);
				List qq3 = q3.getResultList();
				Query req = manager
						.createNativeQuery("insert into RequestBean (bId,bookName,uId,name) values (?,?,?,?)");
				req.setParameter(1, bId);
				req.setParameter(2, qq1.get(0));
				req.setParameter(3, uId);
				req.setParameter(5, qq.get(0));

				req.executeUpdate();
				transaction.commit();
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@SuppressWarnings("unused")
	public LinkedList<Integer> bookHistoryDetails(int uId) {
		int count = 0;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select m from BookIssueDetails m";
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
			factory = Persistence.createEntityManagerFactory("TestPersistence");
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
		manager.close();
		factory.close();

		return bookBeans;
	}

}
