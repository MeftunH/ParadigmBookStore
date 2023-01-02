package com.paradigmbookstore.service;

import com.paradigmbookstore.dto.BookResponse;
import com.paradigmbookstore.dto.CategoryType;
import com.paradigmbookstore.model.Book;
import com.paradigmbookstore.model.Category;
import com.paradigmbookstore.repository.BookRepository;
import com.paradigmbookstore.request.book.BookSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    private static BookResponse getBuild(Book model) {
        return BookResponse.builder()
                .authorName(model.getAuthorName())
                .title(model.getTitle())
                .imageUrl(model.getImage()
                .getImageUrl())
                .build();
    }

    //TODO: Convert to request param
    public List<BookResponse> listBooks(BookSearchRequest bookSearchRequest) {
        return bookRepository.findAll(PageRequest.of(bookSearchRequest.getPage(), bookSearchRequest.getSize()))
                .getContent()
                .stream()
                .map(BookListService::getBuild)
                .collect(Collectors.toList());
    }

    public List<BookResponse> searchByCategory(CategoryType categoryType) {
        Category category = categoryService.findByName(categoryType.getValue());
        return category.getBooks()
                .stream().map(BookListService::getBuild)
                .collect(Collectors.toList());
    }

}
