package com.lms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.Author_Entity;
import com.lms.model.AuthorDTO;
import com.lms.service.Author_Service;
import com.lms.utility.Converter;

@RestController
@RequestMapping("/api")
public class Author_Controller {
	
	@Autowired
	private Author_Service author_service;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createAuthor")
	 ResponseEntity<AuthorDTO> registerAuthor(@Valid @RequestBody AuthorDTO authorDTO)	
	 {
		final Author_Entity author=converter.convertToAuthorEntity(authorDTO);
		return new ResponseEntity<AuthorDTO>(author_service.registerAuthor(author),HttpStatus.CREATED); 
	 }
	
	@PostMapping("/assignment/{aid}/{bid}")
	public String assignBookToAuthopr(@PathVariable("aid") int aid,
			@PathVariable("bid") int bid)
	{
		return author_service.assignBookToAuthor(aid, bid);
	}

	

}
