package com.paradigmbookstore.request.book;

import com.paradigmbookstore.model.BookStatus;
import com.paradigmbookstore.model.Category;
import com.paradigmbookstore.model.Image;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;

@Data
public final class SaveBookRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String authorName;
    @NotBlank
    private String publisherName;
    @NotNull
    private BookStatus status;
    @NotNull
    private Integer lastPageNumber;
    private File image;
    @NotNull
    private Long categoryId;
    @NotNull
    private Integer totalPageNumber;
}
