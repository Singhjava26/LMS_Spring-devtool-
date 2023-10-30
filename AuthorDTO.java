package com.lms.model;

import java.awt.print.Book;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDTO {
	
private int id;
	
	private String name;
	
	private String email_id;
	
	private String ph_no;
	private boolean status=Boolean.TRUE;
	
	List<Book> books;
}
