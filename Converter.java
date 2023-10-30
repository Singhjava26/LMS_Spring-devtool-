package com.lms.utility;




import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.lms.entity.Author_Entity;
import com.lms.entity.Book_Entity;
import com.lms.model.AuthorDTO;
import com.lms.model.BookDTO;

@Component
public class Converter {
	
	public  Book_Entity convertToBookEntity(BookDTO bookDTO)
	{
		Book_Entity book=new Book_Entity();
		if(bookDTO!=null)
		{
			BeanUtils.copyProperties(bookDTO, book);
		}
	     return book;
	}

	//convert from Entity to DTO
	public BookDTO convertToBookDTO(Book_Entity book)
	{
		BookDTO bookDTO=new BookDTO();
		if(book!=null)
		{
			BeanUtils.copyProperties(book, bookDTO);
		}
		return bookDTO;
	}



	//convert from DTO to Entity

	public  Author_Entity convertToAuthorEntity(AuthorDTO authorDTO)
	{
		Author_Entity author=new Author_Entity();
		if(authorDTO!=null)
		{
			BeanUtils.copyProperties(authorDTO, author);
		}
	     return author;
	}

	//convert from Entity to DTO
	public AuthorDTO convertToAuthorDTO(Author_Entity author)
	{
		AuthorDTO authorDTO=new AuthorDTO();
		if(author!=null)
		{
			BeanUtils.copyProperties(author, authorDTO);
		}
		return authorDTO;
	}
	}
