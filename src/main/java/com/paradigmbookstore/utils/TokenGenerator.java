package com.paradigmbookstore.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.paradigmbookstore.exception.GenericException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {
    @Value("${jwt-variables.KEY}")
    private String KEY;

    @Value("${jwt-variables.EXPIRATION_TIME}")
    private long EXPIRATION_TIME;

    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;

    public String generateToken(Authentication authentication) {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + (EXPIRATION_TIME * 60 * 1000)))
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }

    public DecodedJWT verifyJWT(String token)
    {
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        try{
            return verifier.verify(token);
        }
        catch (Exception e){
            throw GenericException.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }
}
