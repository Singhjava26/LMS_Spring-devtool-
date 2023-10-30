package com.lms.entity;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(length = 50)
	private String name;
	@Column(length = 100)
	private String type;
	@Column(unique = true)
	private String quantity;
	private boolean status=Boolean.TRUE;
	
	//many books -one author
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "aId")
	@JsonIgnoreProperties("books")
	private Author_Entity author;
}
