package com.capgemini.librarymanagement.factory;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dao.AdminDAOImplementation;
import com.capgemini.librarymanagement.service.AdminServiceDAO;
import com.capgemini.librarymanagement.service.AdminServiceImplementation;

public class AdminFactory {
	public static AdminDAO getAdminDAO() {
		return new AdminDAOImplementation();
	}
	public static AdminServiceDAO getAdminServiceDAO() {
		return new AdminServiceImplementation();
	}
	

}
