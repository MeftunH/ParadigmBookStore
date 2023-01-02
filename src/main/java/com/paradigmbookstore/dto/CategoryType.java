package com.paradigmbookstore.dto;


import lombok.Getter;

@Getter
public enum CategoryType {
    SCIENCE("Science"),
    FICTION("Fiction"),
    ;

    private final String value;
    CategoryType(String value) {
        this.value = value;
    }
}
