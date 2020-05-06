package com.capgemini.librarymanagementsystemspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystemspring.dto.LibraryManagementResponce;
import com.capgemini.librarymanagementsystemspring.exception.LmsException;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler
	public LibraryManagementResponce myExceptionHandler(LmsException lmsException) {
		LibraryManagementResponce response = new LibraryManagementResponce();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}
}
