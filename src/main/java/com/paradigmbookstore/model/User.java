package com.paradigmbookstore.model;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "user")
public class User extends BaseEntity {
    private String username;
    private String password;
}
