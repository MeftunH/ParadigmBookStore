package com.paradigmbookstore.repository;

import com.paradigmbookstore.model.Book;
import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Arrays;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Category> {
  List<Book> findByStatus(BookStatus bookStatus);

  List<Book> findByTitle(String title);
}
