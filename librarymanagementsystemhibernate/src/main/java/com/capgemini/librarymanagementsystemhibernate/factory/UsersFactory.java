package com.capgemini.librarymanagementsystemhibernate.factory;

import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAO;
import com.capgemini.librarymanagementsystemhibernate.dao.UsersDAOImp;
import com.capgemini.librarymanagementsystemhibernate.service.UsersService;
import com.capgemini.librarymanagementsystemhibernate.service.UsersServiceImp;

public class UsersFactory {
	public static UsersDAO getUsersDAO() {
		return new UsersDAOImp();
	}
	public static UsersService  getUsersService() {
		return new UsersServiceImp();
	}
}
