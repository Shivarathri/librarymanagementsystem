package com.capgemini.librarymanagement.factory;

import com.capgemini.librarymanagement.dao.StudentDAO;
import com.capgemini.librarymanagement.dao.StudentDAOImplementation;
import com.capgemini.librarymanagement.service.StudentServiceDAO;
import com.capgemini.librarymanagement.service.StudentServiceImplementation;

public class StudentFactory {
	public static StudentDAO getStudentDAO() {
		return new StudentDAOImplementation();
	}
	public static StudentServiceDAO getStudentServiceDAO() {
		return new  StudentServiceImplementation();
			
		
	}
}
