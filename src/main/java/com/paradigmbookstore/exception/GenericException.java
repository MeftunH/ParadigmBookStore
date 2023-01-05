package com.paradigmbookstore.exception;

import com.amazonaws.services.codedeploy.model.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private CustomErrorCode customErrorCode;
}
