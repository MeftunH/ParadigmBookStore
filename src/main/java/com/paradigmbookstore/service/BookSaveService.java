package com.paradigmbookstore.service;

import com.paradigmbookstore.dto.BookListResponse;
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
    public BookListResponse saveBook(SaveBookRequest saveBookRequest)
   {
       Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());

       final Book book = Book.builder()
               .category(category)
               .status(saveBookRequest.getStatus())
               .title(saveBookRequest.getTitle())
               .authorName(saveBookRequest.getAuthorName())
               .lastPageNumber(saveBookRequest.getLastPageNumber())
               .totalPageNumber(saveBookRequest.getTotalPageNumber())
               .build();

       bookRepository.save(book);
       final Book fromDB = bookRepository.save(book);
       return BookListResponse.builder()
               .categoryName(book.getCategory().getName())
               .id(fromDB.getId())
               .status(book.getStatus())
               .authorName(book.getAuthorName())
               .publisherName(book.getPublisherName())
               .totalPageNumber(book.getTotalPageNumber())
               .lastPageNumber(book.getLastPageNumber())
               .build();

   }
}
