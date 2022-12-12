package com.example.paradigmbookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
}
