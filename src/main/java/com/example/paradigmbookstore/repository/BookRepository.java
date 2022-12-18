package com.example.paradigmbookstore.repository;

import com.example.paradigmbookstore.model.Book;
import com.example.paradigmbookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Category> {

}
