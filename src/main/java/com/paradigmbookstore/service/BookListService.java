package com.paradigmbookstore.service;

import com.paradigmbookstore.dto.BookResponse;
import com.paradigmbookstore.repository.BookRepository;
import com.paradigmbookstore.repository.CategoryRepository;
import com.paradigmbookstore.request.book.BookSearchRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookListService
{
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    //TODO: Convert to request param
    public List<BookResponse> listBooks(BookSearchRequest bookSearchRequest)
    {
       return bookRepository.findAll(PageRequest.of(bookSearchRequest.getPage(), bookSearchRequest.getSize()))
               .getContent()
               .stream()
               .map(model ->
                   BookResponse.builder()
                            .authorName(model.getAuthorName())
                            .title(model.getTitle())
                            .imageUrl(model.getImage().getImageUrl())
                            .build())
                            .collect(Collectors.toList());

    }

}
