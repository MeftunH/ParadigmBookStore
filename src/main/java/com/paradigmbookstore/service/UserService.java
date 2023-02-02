package com.paradigmbookstore.service;

import com.paradigmbookstore.dto.UserDto;
import com.paradigmbookstore.exception.GenericException;
import com.paradigmbookstore.model.User;
import com.paradigmbookstore.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        return UserDto.builder()
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .email(savedUser.getEmail())
                .build();
    }
    public UserDto getUser(String username) {
        var savedUser = findUserByUsername(username);
        return UserDto.builder()
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .email(savedUser.getEmail())
                .build();
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> GenericException.builder().httpStatus(HttpStatus.NOT_FOUND).build());

    }
}
