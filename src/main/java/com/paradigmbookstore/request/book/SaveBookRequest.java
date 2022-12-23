package com.paradigmbookstore.request.book;

import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.model.Category;
import com.paradigmbookstore.model.Image;
import lombok.Data;

import javax.persistence.*;
import java.io.File;

@Data
public final class SaveBookRequest {
    private String title;
    private String authorName;
    private BookStatus status;
    private Category category;
    private Integer lastPageNumber;
    private File file;
    private Long id;
}
