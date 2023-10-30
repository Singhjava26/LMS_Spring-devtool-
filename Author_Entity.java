package com.lms.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author_Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(length = 100)
	private String email_id;
	@Column(unique = true)
	private String ph_no;
	private boolean status=Boolean.TRUE;
	
	//one author can teach many books
	@OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST) //author id will be foreign key
	@JsonIgnoreProperties("author")
	List<Book_Entity> books;//in books table

}
