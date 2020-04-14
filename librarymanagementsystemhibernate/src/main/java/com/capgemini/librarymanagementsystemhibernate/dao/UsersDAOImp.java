package com.capgemini.librarymanagementsystemhibernate.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemhibernate.dto.BookBean;
import com.capgemini.librarymanagementsystemhibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemhibernate.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;

public class UsersDAOImp implements UsersDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;
	public boolean register(UsersBean info) {

		try {
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
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql="select u from UsersBean u where u.email=:email and u.password=:password";
			TypedQuery<UsersBean> query = manager.createQuery(jpql,UsersBean.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UsersBean bean = query.getSingleResult();
			return bean;
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();
			factory.close();
		}

	}
	public boolean addBook(BookBean book) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "insert into BookBean (bId,bookName,author,category,publisher) values (:bId,:bookName,:author,:category,:publisher)";
			Query query = manager.createQuery(jpql);
			query.setParameter("bId",book.getBId());
			query.setParameter("bookName",book.getBookName());
			query.setParameter("author",book.getAuthor());
			query.setParameter("category", book.getCategory());
			query.setParameter("publisher", book.getPublisher());
			int count = query.executeUpdate();
			transaction.commit();
			if (count!=0) {
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

	public LinkedList<BookBean> searchBookByTitle(String bookName) {

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from BookBean m where m.bookName=:bookName";
			TypedQuery<BookBean> query=manager.createQuery(jpql, BookBean.class);
			query.setParameter("bookName", bookName);
			LinkedList<BookBean> list=(LinkedList<BookBean>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
			manager.close();
			factory.close();
		}
		
	}

	public LinkedList<BookBean> searchBookByAuthor(String author) {

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from bookBean m where m.author=:author";
			TypedQuery<BookBean> query=manager.createQuery(jpql, BookBean.class);
			query.setParameter("author", author);
			LinkedList<BookBean> list=(LinkedList<BookBean>) query.getResultList();
			if (list!=null) {
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
		
		manager.close();
		factory.close();
		
		}
	}


	public LinkedList<BookBean> searchBookById(int bId) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from BookBean m where m.bId = :bId";
			TypedQuery<BookBean> query=manager.createQuery(jpql, BookBean.class);
			query.setParameter("bId", bId);
			LinkedList<BookBean> list=(LinkedList<BookBean>) query.getResultList();
			if(list!=null) {
				return list;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
		manager.close();
		factory.close();
		
		}

	}

	public boolean updateBook(BookBean bean) {

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean record = manager.find(BookBean.class, bean.getBId());
			record.setBookName(bean.getBookName());
			transaction.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
		
	}

	public boolean removeBook(int bid) {

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, bid);
			bean.setBId(bid);
			manager.remove(bean);
			//manager.persist(bean);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
		
		manager.close();
		factory.close();
		}
		return false;
	}



	public LinkedList<BookBean> getBooksInfo() {

		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql="select m from BookBean m";
			TypedQuery<BookBean> query=manager.createQuery(jpql, BookBean.class);
			LinkedList<BookBean> list=(LinkedList<BookBean>) query.getResultList();
			if (list!=null) {
				return list;
			} else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			return null;
		} finally {
		
		manager.close();
		factory.close();
		}
		
	}

	public List<UsersBean> showUsers() {

		try {
			transaction.begin();
			String jpql = "select m from UsersBean m";
			TypedQuery<UsersBean> query = (TypedQuery<UsersBean>) manager.createNativeQuery(jpql, UsersBean.class);
			List<UsersBean> recordList = query.getResultList();
			if(recordList!=null) {
				return recordList;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

		return null;
	}

	public List<RequestBean> showRequest() {

		try {
			transaction.begin();
			String jpql = "select m from RequestBean m";
			TypedQuery<RequestBean> query = (TypedQuery<RequestBean>) manager.createNativeQuery(jpql, RequestBean.class);
			//manager.persist(query);
			List<RequestBean> recordList = query.getResultList();
			if(recordList!=null) {
				return recordList;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;

	}

	public boolean issueBook(int bId, int uId) {
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if (rs != null) {
				String jpql1 = "select r from RequestDetails r join r.users u on r.uId=u.uId join r.books b on r.bId=b.bId where u.uId=:uId and b.bId=:bId";
				TypedQuery<RequestBean> query1 = manager.createQuery(jpql1,RequestBean.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				query1.setParameter("userId", uId);
				RequestBean rs1 = query1.getSingleResult();
				if (rs1 != null) {
					transaction.begin();
					String jpql2 = "insert into BookIssueDetails(bId,uId,issueDate,returnDate) values(:bId,:uId,:issueDate,:returnDate)";
					Query query2 = manager.createNativeQuery(jpql2);
					query2.setParameter("bId", bId);
					query2.setParameter("uId", uId);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					query2.setParameter("issueDate", java.sql.Date.valueOf(issueDate));
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					query2.setParameter("returnDate", java.sql.Date.valueOf(returnDate));
					int count = query2.executeUpdate();
					transaction.commit();
					if (count != 0) {
						transaction.begin();
						String jpql3 = "Insert into BorrowedBooks(bId,uId,email) values(:bId,:uId,(select u.email from UsersBean u where u.uId=:userId))";
						Query query3 = manager.createNativeQuery(jpql3);
						query3.setParameter("bId", bId);
						query3.setParameter("uId", uId);
						query3.setParameter("userId", uId);
						int count1 = query3.executeUpdate();
						transaction.commit();
						if (count1 != 0) {
							return true;
						} else {
							return false;
						}
					} else {
						throw new LMSException("Book Not issued");
					}
				} else {
					throw new LMSException("The respective user have not placed any request");
				}
			} else {
				throw new LMSException("There is no book exist with bookId"+bId);
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


	public boolean request(int uId, int bId) {
		int count=0;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
			query.setParameter("bId", bId);
			BookBean rs = query.getSingleResult();
			if(rs != null) {
				String jpql1 = "select b from BorrowedBooks b join UsersBean u on u.uId=b.users.uId join BookBean bk on bk.bId=b.books.bId where u.uId=:uId and bk.bId=:bId";
				TypedQuery<BorrowedBooks> query1 = (TypedQuery<BorrowedBooks>) manager.createNativeQuery(jpql1,BorrowedBooks.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				BorrowedBooks rs1 = query1.getSingleResult();
				if(rs1 == null) {
					String jpql2 = "select b from BookIssueDetails b join b.users u on u.uId=b.uId where u.uId=:uId";
					TypedQuery<BookIssueDetails> query2 = (TypedQuery<BookIssueDetails>) manager.createNativeQuery(jpql2,BookIssueDetails.class);
					query2.setParameter("uId", uId);
					List<BookIssueDetails> rs2 = query2.getResultList();
					for(BookIssueDetails p : rs2) {
						noOfBooks = count++;
					}
					if(noOfBooks<3) {
						transaction.begin();
						String jpql3 = "insert into RequestDetails(uId,fullName,bId,bookName,email) values(:uId,(select u.firstName from UsersBean u where u.uId=:userId),:bId,"
								+ "(select b.bookName from BookBean b where b.bId=:bookId),(select u.email from UsersBean where u.uId=:user_Id))" ;
						Query query3 = manager.createNativeQuery(jpql3);
						query3.setParameter("uId", uId);
						query3.setParameter("userId", uId);
						query3.setParameter("bId", bId);
						query3.setParameter("bookId", bId);
						query3.setParameter("user_Id", uId);
						int count1 = query3.executeUpdate();
						transaction.commit();
						if (count1 != 0) {
							return true;
						} else {
							return false;
						}

					} else {
						throw new LMSException("You have crossed the book limit");
					}
				} else {
					throw new LMSException("You have already borrowed the requested book");
				}
			} else {
				throw new LMSException("The book with requested id is not present");
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


public List<BorrowedBooks> borrowedBook(int uId) {
	try {
		manager = factory.createEntityManager();
		String jpql = "select b from BorrowedBooks b where b.uId=:uId";
		TypedQuery<BorrowedBooks> query = manager.createQuery(jpql,BorrowedBooks.class);
		query.setParameter("uId", uId);
		List<BorrowedBooks> recordList = query.getResultList();
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
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		String jpql = "select m from BookBean m where m.bId=:bId";
		TypedQuery<BookBean> query = manager.createQuery(jpql,BookBean.class);
		query.setParameter("bId", bId);
		BookBean rs = query.getSingleResult();
		if(rs != null) {
			String jpql1 = "select m from BookIssueDetails m where m.bId=:bId and m.uId=uId ";
			TypedQuery<BookIssueDetails> query1 = manager.createQuery(jpql,BookIssueDetails.class);
			query1.setParameter("bId", bId);
			query1.setParameter("uId", uId);
			BookIssueDetails rs1 = query1.getSingleResult();
			if (rs1 != null) {
				Date issueDate = rs1.getIssueDate();
				Calendar cal = Calendar.getInstance();
				Date returnDate = cal.getTime();
				long difference = issueDate.getTime() - returnDate.getTime();
				float daysBetween = (difference / (1000*60*60*24));
				if (daysBetween>7) {
					float fine = daysBetween*5;
					System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
					if (status=="yes") {
						transaction.begin();
						String jpql2 = "delete from BookIssueDetails m where m.bId=:bId and m.uId=:uId";
						Query query2 = manager.createNativeQuery(jpql2);
						query2.setParameter("bId", bId);
						query2.setParameter("uId", uId);
						int count1 = query2.executeUpdate();
						transaction.commit();
						if (count1 != 0) {
							transaction.begin();
							String jpql3 = "delete from BorrowedBooks m where m.bId=:bId and m.uId=:uId";
							Query query3 = manager.createNativeQuery(jpql3);
							query3.setParameter("bId", bId);
							query3.setParameter("uId", uId);
							int count2 = query3.executeUpdate();
							transaction.commit();
							if (count2 != 0) {
								transaction.begin();
								String jpql4 = "delete from BorrowedBooks m where m.bId=:bId and m.uId=:uId";
								Query query4 = manager.createNativeQuery(jpql4);
								query4.setParameter("bId", bId);
								query4.setParameter("uId", uId);
								int count3 = query4.executeUpdate();
								transaction.commit();
								if (count3 != 0) {
									return true;
								} else {
									return false;
								}
							} else {
								return false;
							}

						} else {
							return false;
						}

					} else {
						throw new LMSException("The User has to pay fine for delaying book return");
					}
				} else {
					transaction.begin();
					String jpql2 = "delete from BookIssueDetails b where b.bId=:bId and u.uId=:uId";
					Query query2 = manager.createNativeQuery(jpql2);
					query2.setParameter("bId", bId);
					query2.setParameter("uId", uId);
					int count1 = query2.executeUpdate();
					transaction.commit();
					if (count1 != 0) {
						transaction.begin();
						String jpql3 = "delete from BorrowedBooks b where b.bId=:bId and b.uId=:uId";
						Query query3 = manager.createNativeQuery(jpql3);
						query3.setParameter("bId", bId);
						query3.setParameter("uId", uId);
						int count2 = query3.executeUpdate();
						transaction.commit();
						if (count2 != 0) {
							transaction.begin();
							String jpql4 = "delete from BorrowedBooks b where b.bId=:bId and b.uId=:uId";
							Query query4 = manager.createNativeQuery(jpql4);
							query4.setParameter("bId", bId);
							query4.setParameter("uId", uId);
							int count3 = query4.executeUpdate();
							transaction.commit();
							if (count3 != 0) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}

					} else {
						return false;
					}
				}

			} else {
				throw new LMSException("This respective user hasn't borrowed any book");
			}
		} else {
			throw new LMSException("book doesnt exist");
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

public LinkedList<Integer> bookHistoryDetails(int uId) {
	int count=0;
	manager = factory.createEntityManager();
	String jpql = "select m from BookIssueDetails m";
	TypedQuery<BookIssueDetails> query = manager.createQuery(jpql,BookIssueDetails.class);
	LinkedList<BookIssueDetails> recordList = (LinkedList<BookIssueDetails>)query.getResultList();
	for(BookIssueDetails p : recordList) {
		noOfBooks = count++;
	}
	LinkedList<Integer> list = new LinkedList<Integer>();
	list.add(noOfBooks);
	manager.close();
	factory.close();
	return list;
}

public LinkedList<BookBean> getBookIds() {
	try {

		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		String jpql="select m from bookBean";
		TypedQuery<BookBean> query=manager.createQuery(jpql, BookBean.class);
		LinkedList<BookBean> list=(LinkedList<BookBean>) query.getResultList();
		if (list!=null) {
			return list;
		} else {
			return null;
		}
	} catch (Exception e) {

		e.printStackTrace();
		transaction.rollback();
	}
	manager.close();
	factory.close();
	return null;
}


}
