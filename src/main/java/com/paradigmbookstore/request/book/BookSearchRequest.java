package com.paradigmbookstore.request.book;

import lombok.Getter;

@Getter
public class BookSearchRequest {
    private int size;
    private int page;
}
