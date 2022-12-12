package com.example.paradigmbookstore.model;

import com.example.paradigmbookstore.dto.CategoryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@NoArgsConstructor
@SuperBuilder
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String authorName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
