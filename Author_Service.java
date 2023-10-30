package com.lms.service;

import com.lms.entity.Author_Entity;
import com.lms.model.AuthorDTO;

public interface Author_Service {
	AuthorDTO registerAuthor(Author_Entity author);
	  String assignBookToAuthor(int aid,int bid);

}
