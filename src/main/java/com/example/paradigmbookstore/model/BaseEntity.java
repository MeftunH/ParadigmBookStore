package com.example.paradigmbookstore.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // This annotation is used to indicate that a class is a base class for an entity hierarchy.
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
}