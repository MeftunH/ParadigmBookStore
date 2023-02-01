package com.paradigmbookstore.dto;

import com.paradigmbookstore.model.Role;
import com.paradigmbookstore.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto{
    private String username;
    private Role role;
    private String email;
}