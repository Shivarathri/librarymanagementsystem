package com.capgemini.librarymanagementsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystemspring.dto.BookBean;
import com.capgemini.librarymanagementsystemspring.dto.BorrowedBooksBean;
import com.capgemini.librarymanagementsystemspring.dto.LibraryManagementResponce;
import com.capgemini.librarymanagementsystemspring.dto.RequestBean;
import com.capgemini.librarymanagementsystemspring.dto.UsersBean;
import com.capgemini.librarymanagementsystemspring.service.UsersService;

@RestController
public class LibraryManagementRestController {
	@Autowired
	private UsersService sevice;

	@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public LibraryManagementResponce addUser(@RequestBody UsersBean info) {
		boolean isAdded = sevice.register(info);
		LibraryManagementResponce responce = new LibraryManagementResponce();
		if (isAdded) {

			responce.setMessage("User is added");
		} else {
			responce.setError(true);
			responce.setMessage("Unable to Add User");
		}
		return responce;
	}

	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementResponce authentication(@RequestBody String email, String password) {
		UsersBean userLogin = sevice.auth(email, password);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (userLogin != null) {
			response.setMessage("Login succesfully");
		} else {
			response.setError(true);
			response.setMessage("Invalid credentials,Please try again");
		}
		return response;
	}

	@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public LibraryManagementResponce addBook(@RequestBody BookBean bookBean) {
		boolean isAdded = sevice.addBook(bookBean);
		LibraryManagementResponce responce = new LibraryManagementResponce();
		if (isAdded) {

			responce.setMessage("Book is added");
		} else {
			responce.setError(true);
			responce.setMessage("Unable to Add Book");
		}
		return responce;
	}

	@DeleteMapping(path = "/deleteBook/{bId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryManagementResponce deleteEmployee(@PathVariable(name = "bId") int bId) {
		boolean isDeleted = sevice.removeBook(bId);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (isDeleted) {
			response.setMessage("Record is  Deleted");
		} else {
			response.setError(true);
			response.setMessage("Record is not Deleted");
		}
		return response;
	}

	@PutMapping(path = "/updateBook", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryManagementResponce updateBook(@RequestBody BookBean bookBean) {
		boolean isUpdated = sevice.updateBook(bookBean);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (isUpdated) {
			response.setMessage("Book is  Updated");
		} else {
			response.setError(true);
			response.setMessage("Record is not Updated");
		}
		return response;
	}

	@GetMapping(path = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryManagementResponce getAllBooks() {
		List<BookBean> bookList = sevice.getBooksInfo();
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (bookList != null && !bookList.isEmpty()) {
			response.setBookList(bookList);
		} else {
			response.setError(true);
			response.setMessage("No data present");
		}
		return response;
	}

	@GetMapping(path = "/getBookByName", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BookBean> getBookByName(String bookName) {
		List<BookBean> bookBean = sevice.searchBookByTitle(bookName);
		return bookBean;
	}

	@GetMapping(path = "/getBookById", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BookBean> getBook(int bId) {
		List<BookBean> bookBean = sevice.searchBookById(bId);
		return bookBean;
	}

	@GetMapping(path = "/getBookByAuthor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BookBean> getBook(String author) {
		List<BookBean> bookBean = sevice.searchBookByAuthor(author);
		return bookBean;
	}

	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryManagementResponce getAllUsers() {
		List<UsersBean> userList = sevice.showUsers();
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (userList != null && !userList.isEmpty()) {
			response.setUserList(userList);
		} else {
			response.setError(true);
			response.setMessage("No data present");
		}
		return response;

	}

	@GetMapping(path = "/getAllRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryManagementResponce getAllRequest() {
		List<RequestBean> requestList = sevice.showRequest();
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (requestList != null && !requestList.isEmpty()) {
			response.setRequestList(requestList);
		} else {
			response.setError(true);
			response.setMessage("No data present");
		}
		return response;

	}

	@GetMapping(path = "/getBookIds", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Integer> getBookIds() {
		List<Integer> bookIds = sevice.getBookIds();
		return bookIds;
	}

	@GetMapping(path = "/borrowedBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LibraryManagementResponce borrowedBoooks(int uId) {
		List<BorrowedBooksBean> borrowedBooksList = sevice.borrowedBook(uId);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (borrowedBooksList != null && !borrowedBooksList.isEmpty()) {
			response.setBorrowedBooksList(borrowedBooksList);
		} else {
			response.setError(true);
			response.setMessage("No data present");
		}
		return response;
	}

	@GetMapping(path = "/getBookIssueDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Integer> getBookIssueDetails(int uId) {
		List<Integer> booksHistory = sevice.bookHistoryDetails(uId);
		return booksHistory;

	}

	@PostMapping(path = "/requestBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public LibraryManagementResponce requestBook(int bId, int uId) {
		boolean isRequested = sevice.request(uId, bId);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (isRequested) {
			response.setMessage("Book is  Requested");
		} else {
			response.setError(true);
			response.setMessage("Book is not Requested");
		}
		return response;
	}

	@PostMapping(path = "/issueBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public LibraryManagementResponce issueBook(int bId, int uId) {
		boolean isIssued = sevice.issueBook(bId, uId);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (isIssued) {
			response.setMessage("Book is  Issued");
		} else {
			response.setError(true);
			response.setMessage("Book is not issued");
		}
		return response;
	}

	@PostMapping(path = "/returnBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	@ResponseBody
	public LibraryManagementResponce returnBook(int bId, int uId, String status) {
		boolean isReturned = sevice.returnBook(bId, uId, status);
		LibraryManagementResponce response = new LibraryManagementResponce();
		if (isReturned) {
			response.setMessage("Book is  Returned");
		} else {
			response.setError(true);
			response.setMessage("Book is not Returned");
		}
		return response;
	}

}
