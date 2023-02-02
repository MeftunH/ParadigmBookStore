package com.paradigmbookstore.service;

import com.paradigmbookstore.dto.TokenResponseDTO;
import com.paradigmbookstore.exception.CustomErrorCode;
import com.paradigmbookstore.exception.GenericException;
import com.paradigmbookstore.request.Login.LoginRequest;
import com.paradigmbookstore.utils.TokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserService userService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponseDTO login(LoginRequest loginRequest) {
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
                    return TokenResponseDTO.builder()
                    .accessToken(tokenGenerator.generateToken(auth))
                    .userDto(userService.getUser(loginRequest.getUsername()))
                    .build();
        } catch (Exception e){
            throw GenericException.builder().httpStatus(HttpStatus.NOT_FOUND).customErrorCode(CustomErrorCode.USER_NOT_FOUND).build();
        }
    }
}
