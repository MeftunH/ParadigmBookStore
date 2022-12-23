package com.paradigmbookstore.service;

import com.paradigmbookstore.model.Book;
import com.paradigmbookstore.model.Category;
import com.paradigmbookstore.repository.BookRepository;
import com.paradigmbookstore.request.book.SaveBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BookSaveService {
    private final BookRepository bookRepository;
   private final CategoryService categoryService;

   @Transactional
    public void saveBook(SaveBookRequest saveBookRequest)
   {
       Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());

       final Book book = Book.builder()
               .category(category)
               .status(saveBookRequest.getStatus())
               .title(saveBookRequest.getTitle())
               .authorName(saveBookRequest.getAuthorName())
               .lastPageNumber(saveBookRequest.getLastPageNumber())
               .build();

   }
}
