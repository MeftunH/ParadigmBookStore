package com.paradigmbookstore.service;

import com.paradigmbookstore.dto.BookResponse;
import com.paradigmbookstore.dto.CategoryType;
import com.paradigmbookstore.model.Book;
import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.model.Category;
import com.paradigmbookstore.repository.BookRepository;
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
    public List<BookResponse> listBooks(int size, int page) {
        return bookRepository.findAll(PageRequest.of(page, size))
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

    public List<BookResponse> searchByBookStatus(BookStatus bookStatus) {
        return bookRepository.findByStatus(bookStatus)
                .stream()
                .map(each ->
                        BookResponse.builder()
                                .id(each.getId())
                                .imageUrl(each.getImage().getImageUrl())
                                .build()).collect(Collectors.toList());

    }

    public List<BookResponse> findByTitle(String title) {
        return bookRepository.findByTitle(title)
                .stream()
                .map(
                        each ->
                                BookResponse.builder()
                                        .id(each.getId())
                                        .imageUrl(each.getImage().getImageUrl())
                                        .build()
                ).collect(Collectors.toList());
    }

}
