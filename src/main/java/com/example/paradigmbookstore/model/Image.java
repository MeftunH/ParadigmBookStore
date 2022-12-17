package com.example.paradigmbookstore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Getter
@SuperBuilder
@NoArgsConstructor
public class Image extends BaseEntity {
    private String imageUrl;

}