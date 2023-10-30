package com.lms.service;

import java.util.List;


import com.lms.entity.Book_Entity;
import com.lms.model.BookDTO;

public interface Book_Service {
	BookDTO createBook(Book_Entity book);
	List<BookDTO> getAllBooks();
	BookDTO getBookById(int id);
	BookDTO updateBook(int id,Book_Entity book);
	String deleteBook(int id);	

}
