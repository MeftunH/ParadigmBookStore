package com.paradigmbookstore.model;
import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    private String email;

}
