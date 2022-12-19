package com.paradigmbookstore.repository;

import com.paradigmbookstore.model.Book;
import com.paradigmbookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Category> {

}
