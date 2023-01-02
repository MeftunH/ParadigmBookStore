package com.paradigmbookstore.dto;

import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@SuperBuilder
@NoArgsConstructor
public class BookResponse {
    private String authorName;
    private String title;
    private BookStatus status;
    private Category category;
    private Integer lastPageNumber;
    private File file;
    private Long categoryId;
    private Integer totalPageNumber;
    private String imageUrl;
}
