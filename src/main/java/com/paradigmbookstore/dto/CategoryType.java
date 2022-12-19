package com.paradigmbookstore.dto;

public enum CategoryType {
    SCIENCE("Science"),
    FICTION("Fiction"),
    ;

    private final String value;
    CategoryType(String value) {
        this.value = value;
    }
}
