package com.paradigmbookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "category")
@SuperBuilder
@NoArgsConstructor
@Getter
public class Category extends BaseEntity {
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;
    private String name;

}
