package com.example.paradigmbookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@SuperBuilder
@NoArgsConstructor
public class Category extends BaseEntity {
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Book> books;
    private String name;

}
