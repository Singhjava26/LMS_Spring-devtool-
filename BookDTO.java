package com.lms.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDTO {
	
	private int Id;
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String name;
	@NotNull
	@Size(min=5,max=100,message = "Name should have min 2 to max 50 characters")
	private String type;
	@NotNull
	private String quantity;
	private AuthorDTO author;

}
