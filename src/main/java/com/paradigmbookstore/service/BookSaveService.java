package com.paradigmbookstore.service;

import com.paradigmbookstore.repository.BookRepository;
import com.paradigmbookstore.request.book.SaveBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookSaveService {
    private final BookRepository bookRepository;
   private final CategoryService categoryService;;

   public void saveBook(SaveBookRequest saveBookRequest)
   {

   }
}
