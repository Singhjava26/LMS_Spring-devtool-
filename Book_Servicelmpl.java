package com.lms.servicelmpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Book_Entity;
import com.lms.exception.ResourceNotFoundException;
import com.lms.model.BookDTO;
import com.lms.repository.Book_Repository;
import com.lms.service.Book_Service;
import com.lms.utility.Converter;

@Service
public class Book_Servicelmpl implements Book_Service {
	
	@Autowired
	private Book_Repository book_Repository;
	
	@Autowired
	private Converter converter;
	


	@Override
	public List<BookDTO> getAllBooks() {
		List<Book_Entity> books=book_Repository.findAll();
		
		//list of type DTO
		List<BookDTO> dtoList=new ArrayList<>();
		for(Book_Entity b:books)
		{
			dtoList.add(converter.convertToBookDTO(b));
		}
		
		return dtoList;
	}

	@Override
	public BookDTO createBook(Book_Entity book) {
	
		Book_Entity boo=book_Repository.save(book);
		return converter.convertToBookDTO(boo);
	}

	@Override
	public BookDTO updateBook(int id, Book_Entity book) {
		Book_Entity b=book_Repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book", "Id", id));
		b.setName(book.getName());
		b.setType(book.getType());
		b.setQuantity(book.getQuantity());
		
		Book_Entity boo=book_Repository.save(b);
		return converter.convertToBookDTO(boo);
	}

	@Override
	public BookDTO getBookById(int id) {
		Book_Entity b=book_Repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book", "Id", id));
		return converter.convertToBookDTO(b);
	}

	@Override
	public String deleteBook(int id) {
		book_Repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book", "Id", id));
		
		book_Repository.deleteById(id);
		return "Book got deleted successfully!!";
	}

}
	
