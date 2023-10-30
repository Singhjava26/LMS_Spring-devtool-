package com.lms.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Book_Entity;


public interface Book_Repository extends JpaRepository<Book_Entity, Integer> {

}
