package com.example.paradigmbookstore.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@SuperBuilder
public class Book extends BaseEntity {
    private String title;
    private String authorName;

    @Enumerated(value = EnumType.STRING)
    private BookStatus status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}




