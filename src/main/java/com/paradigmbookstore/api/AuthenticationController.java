package com.paradigmbookstore.api;

import com.paradigmbookstore.dto.TokenResponseDTO;
import com.paradigmbookstore.request.Login.LoginRequest;
import com.paradigmbookstore.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequest loginRequest){
    return ResponseEntity.ok(authenticationService.login(loginRequest));
    }

}
