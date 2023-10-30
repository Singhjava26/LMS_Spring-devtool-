package com.lms.servicelmpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.Author_Entity;
import com.lms.entity.Book_Entity;
import com.lms.exception.ResourceNotFoundException;
import com.lms.model.AuthorDTO;
import com.lms.repository.Author_Repository;
import com.lms.repository.Book_Repository;
import com.lms.service.Author_Service;
import com.lms.utility.Converter;
@Service
public class Author_Servicelmpl implements Author_Service {
	
	@Autowired
	private Author_Repository author_Repository;
	
	@Autowired
	private Book_Repository book_Repository;
	
	@Autowired
	private Converter converter;

	@Override
	public AuthorDTO registerAuthor(Author_Entity author) {
		// TODO Auto-generated method stub
		return converter.convertToAuthorDTO(author_Repository.save(author));
	}

	@Override
	public String assignBookToAuthor(int aid, int bid) {
		Book_Entity b=book_Repository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Author", "Id", aid));
		
		Author_Entity a=author_Repository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Author", "Id", aid));
		
		List<Book_Entity> books=new ArrayList<>();
		books.add(b);
		
		//assign BOOK to author
		a.setBooks(books);
		
		//assign  author to book
		b.setAuthor(a);
		
		author_Repository.save(a);
		
		return "Books assigned to Author successfully";
	}

	/*

	@Override
	public String assignBookToAuthor(int aid, int bid) {
		Book b=book_Repository.findById(bid).orElseThrow(()->
		new ResourceNotFoundException("Book", "Id", bid));
		
		Author a=author_Repository.findById(aid).orElseThrow(()->
		new ResourceNotFoundException("Author", "Id", aid));
		
		List<Book> books=new ArrayList<>();
		books.add(b);
		
		//assign BOOK to author
		a.setBooks(books);
		
		//assign  author to book
		b.setAuthor(a);
		
		Author_Repository.save(a);
		
		return "Books assigned to Author successfully";
	}
	
	*/

	



}



