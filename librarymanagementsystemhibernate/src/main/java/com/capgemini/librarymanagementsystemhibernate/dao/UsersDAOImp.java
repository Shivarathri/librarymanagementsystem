package com.capgemini.librarymanagementsystemhibernate.dao;

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
import com.capgemini.librarymanagementsystemhibernate.dto.RequestBean;
import com.capgemini.librarymanagementsystemhibernate.dto.UsersBean;
import com.capgemini.librarymanagementsystemhibernate.exception.LMSException;

public class UsersDAOImp implements UsersDAO {
	public boolean register(UsersBean info) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UsersBean bean = manager.find(UsersBean.class, info.getEmail());
			if(bean== null) {
				System.out.println("Record Saved");
			} else {
				throw new LMSException("User already Exist");
			}
			manager.persist(info);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

	public UsersBean auth(String email, String password) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			UsersBean bean2= manager.find(UsersBean.class, email);
			bean2.setEmail(email);
			manager.persist(bean2);
			if(bean2.getPassword().equals(password)) {
				return bean2;
			}
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	
	}
	public boolean addBook(BookBean book) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, book.getBid());
			//			if(bean == null) {
			//				System.out.println("Book Added");
			//			} else {
			//				throw new BookException("Book Already Exist");
			//			}
			manager.persist(book);
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	
	}

	public BookBean searchBookTitle(String bname) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, bname);
			manager.persist(bname);
			transaction.commit();
			return bean;
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public BookBean searchBookAuthor(String bAuthor) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, bAuthor);
			//manager.persist(bAuthor);
			manager.persist(bean);
			transaction.commit();
			return bean;
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public BookBean searchBookType(int bid) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, bid);
			manager.persist(bean);
			transaction.commit();
			return bean;
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public boolean updateBook(BookBean bean) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean2 = manager.find(BookBean.class, bean.getBid());
			bean2.setBname(bean.getBname());
			manager.persist(bean);
			System.out.println("updated");
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return false;
	}

	public boolean removeBook(int bid) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBean bean = manager.find(BookBean.class, bid);
			bean.setBid(bid);
			manager.remove(bean);
			//manager.persist(bean);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

	public LinkedList<Integer> getBookIds() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = "select * from bookbean";
			Query query =  manager.createNativeQuery(jpql, BookBean.class);
			List<Integer> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				BookBean bean = (BookBean) it.next();
				System.out.println("----------------------");
				System.out.println("Id:---"+bean.getBid());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public LinkedList<BookBean> getBooksInfo() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = "select * from bookbean";
			TypedQuery<BookBean> query = (TypedQuery<BookBean>) manager.createNativeQuery(jpql, BookBean.class);
			List<BookBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				BookBean bean = (BookBean) it.next();
				System.out.println("----------------------");
				System.out.print("Id:---"+bean.getBid());
				System.out.print(" Name:---"+bean.getBname());
				System.out.println(" Author:---"+bean.getAuthor());
				System.out.println("PublisherName:---"+bean.getPublishername());
				System.out.println("Category:---"+bean.getCategory());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public List<UsersBean> showUsers() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = "select * from usersbean";
			TypedQuery<UsersBean> query = (TypedQuery<UsersBean>) manager.createNativeQuery(jpql, UsersBean.class);
			List<UsersBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				UsersBean bean = (UsersBean) it.next();
				System.out.println("----------------------");
				System.out.print("Id:---"+bean.getId());
				System.out.print(" Name:---"+bean.getName());
				System.out.println(" Email:---"+bean.getEmail());
				System.out.println("Mobile:---"+bean.getMobile());
				System.out.println("Role:---"+bean.getRole());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public List<RequestBean> showRequests() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = "select * from requestbean";
			TypedQuery<RequestBean> query = (TypedQuery<RequestBean>) manager.createNativeQuery(jpql, RequestBean.class);
			//manager.persist(query);
			List<RequestBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				RequestBean bean = (RequestBean) it.next();
				System.out.println("----------------------");
				System.out.print("BookId:---"+bean.getBookInfo().getBid());
				System.out.print("BookName:---"+bean.getBookInfo().getBname());
				System.out.println(" UserId:---"+bean.getUsersInfo().getId());
				System.out.println("UserName:---"+bean.getUsersInfo().getName());
				manager.persist(bean);
			}
			//manager.persist(query);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public boolean bookIssue(UsersBean student, BookBean book) {
//		EntityManagerFactory factory = null;
//		EntityManager manager = null;
//		EntityTransaction transaction = null;
//		try {
//			factory = Persistence.createEntityManagerFactory("TestPersistence");
//			manager = factory.createEntityManager();
//			transaction = manager.getTransaction();
//			transaction.begin();
//			UsersBean bean = new UsersBean();
//			UsersBean bean2= manager.find(UsersBean.class, bean.getRole());
//			
//			manager.persist(bean2);
//			if(bean2.getRole().equals("student")) {
//				BookBean bookBean = new BookBean();
//			}
//			transaction.commit();
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			transaction.rollback();
//		}
//		manager.close();
//		factory.close();
		return false;
	
	}

	public boolean isBookReceived(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}

	public RequestBean requestBook(UsersBean student, BookBean book) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			//			transaction.begin();
			//			RequestBean requestInfo = new RequestBean();
			//			//manager.persist(requestInfo);
			//			UsersBean usersInfo = new UsersBean();
			//			BookBean bookInfo = new BookBean();
			//			boolean flag = false;
			//			boolean isRequestExists = false;
			//
			//			RequestBean bean = manager.find(RequestBean.class, requestInfo.getRid() );
			//			//manager.persist(bean);
			//			manager.merge(bean);
			//			if(bookInfo.getBid() == bean.getBookInfo().getBid()) {
			//				isRequestExists = true;
			//			}
			//
			//			if (!isRequestExists) {
			//				UsersBean usersBean = manager.find(UsersBean.class, student.getEmail());
			//				//manager.persist(usersBean);
			//				manager.merge(usersBean);
			//				if(usersInfo.getId() == usersBean.getId()){
			//					BookBean bookBean = manager.find(BookBean.class, book.getBid());
			//					//manager.persist(bookBean);
			//					manager.merge(bookBean);
			//					if(bookInfo.getBid() == bookBean.getBid()) {
			//						usersInfo = usersBean;
			//						bookInfo = bookBean;
			//						flag = true;
			//					}
			//				}
			//			}
			//
			//			if(flag == true) {
			//				requestInfo.setBookInfo(bookInfo);
			//				requestInfo.setUsersInfo(usersInfo);
			//				RequestBean requestBean = manager.find(RequestBean.class, requestInfo.getRid());
			//				//manager.persist(requestBean);
			//				//manager.persist(requestInfo);
			//				manager.merge(requestBean);
			//				return requestBean;
			//			}
			//			
			//			transaction.commit();
			//		}



			transaction.begin();
			boolean flag = false;
			boolean isRequestExists = false;
			//RequestBean requestInfo = new RequestBean();
			UsersBean usersInfo = new UsersBean();
			BookBean bookInfo = new BookBean();
			//BookBean bean = manager.find(BookBean.class, book.getBid());
			RequestBean requestBean = manager.find(RequestBean.class, book);
			RequestBean  bean = new RequestBean();
			String jpql = "select * from requestbean";
			TypedQuery<RequestBean> query = (TypedQuery<RequestBean>) manager.createNativeQuery(jpql, RequestBean.class);
			List<RequestBean> recordList = query.getResultList();
			Iterator it = recordList.iterator();
			while (it.hasNext()){
				RequestBean bean1 = (RequestBean) it.next();
				manager.merge(bean1);
				if(book.getBid() == bean.getBookInfo().getBid()) {
					isRequestExists = true;
				}
				if (!isRequestExists) {
					String jpql1 = "select * from userbean";
					TypedQuery<UsersBean> query1 = (TypedQuery<UsersBean>) manager.createNativeQuery(jpql, UsersBean.class);
					List<UsersBean> recordList1 = query1.getResultList();
					Iterator it1 = recordList1.iterator();
					while (it1.hasNext()){
						UsersBean bean2 = (UsersBean) it.next();
						manager.merge(bean2);
						if(bean2.getId() == student.getId()) {
							String jpql2 = "select * from bookbean";
							TypedQuery<BookBean> query2 = (TypedQuery<BookBean>) manager.createNativeQuery(jpql, BookBean.class);
							List<BookBean> recordList2 = query2.getResultList();
							Iterator it2 = recordList2.iterator();
							while (it2.hasNext()){
								BookBean bean3 = (BookBean) it.next();
								manager.merge(bean3);
								if(bean3.getBid() == book.getBid()) {
									student = usersInfo;
									book = bookInfo;
									flag = true;
								}
							}
						}
						if(flag == true) {
							bean1.setBookInfo(bookInfo);
							bean1.setUsersInfo(usersInfo);
							manager.merge(bean1);
						}

					}
				}
				transaction.commit();

			}

		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return null;
	}

	public boolean returnBook(UsersBean student, BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}


}
