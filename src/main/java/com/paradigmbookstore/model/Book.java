package com.paradigmbookstore.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book extends BaseEntity {
    private String title;
    private String authorName;
    private String publisherName;

    @Enumerated(value = EnumType.STRING)
    private BookStatus status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Integer lastPageNumber;
    @OneToOne
    private Image image;
    private Integer totalPageNumber;
    private Long userId;
}




