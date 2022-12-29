package com.paradigmbookstore.dto;

import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.model.Category;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@SuperBuilder
public class BookListResponse {
    private Long id;
    private String title;
    private String authorName;
    private String publisherName;
    private BookStatus status;
    private Category category;
    private Integer lastPageNumber;
    private File file;
    private String categoryName;
    private Integer totalPageNumber;
}
