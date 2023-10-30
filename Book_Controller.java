package com.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Book_Entity;
import com.lms.model.BookDTO;
import com.lms.service.Book_Service;
import com.lms.utility.Converter;

@RestController
@RequestMapping("/api")
public class Book_Controller {
	
	@Autowired
	private Book_Service book_service;
	
	@Autowired
	private Converter converter;
	

	
	@PostMapping("/createBook")	
	 ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO)	
	 {
		final Book_Entity book=converter.convertToBookEntity(bookDTO);
		return new ResponseEntity<BookDTO>(book_service.createBook(book),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/getAllBooks")
	List<BookDTO> getAllBooks()
	{
		return book_service.getAllBooks();
	}
	
	@GetMapping("/getBookById/{bid}")
	BookDTO getBookById(@PathVariable("bid") int id)
  {
	   return book_service.getBookById(id);
  }
	
	@PutMapping("/updateBook/{id}")
	BookDTO	updateBook(@Valid @PathVariable int id,@RequestBody BookDTO bookDTO)
{
		final Book_Entity book=converter.convertToBookEntity(bookDTO);
	return book_service.updateBook(id, book);
}
	@DeleteMapping("/deleteBook/{id}")
	String deleteBook(@PathVariable int id)
	{
		return book_service.deleteBook(id);
	}
}

	


