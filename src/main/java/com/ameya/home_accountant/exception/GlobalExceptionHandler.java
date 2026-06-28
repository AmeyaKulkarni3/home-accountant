package com.ameya.home_accountant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ameya.home_accountant.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidGoogleTokenException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidGoogleToken(
            InvalidGoogleTokenException ex) {

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.<Void>builder()
                        .success(false)
                        .message(ex.getMessage())
                        .build());

    }
    
    // @ExceptionHandler(UserDisabledException.class)
    // public ResponseEntity<ApiResponse<Void>> handleUserDisabled(
    //         UserDisabledException ex) {

    //     return ResponseEntity
    //             .status(HttpStatus.FORBIDDEN)
    //             .body(ApiResponse.<Void>builder()
    //                     .success(false)
    //                     .message(ex.getMessage())
    //                     .build());

    // }

    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(
    //         ResourceNotFoundException ex) {

    //     return ResponseEntity
    //             .status(HttpStatus.NOT_FOUND)
    //             .body(ApiResponse.<Void>builder()
    //                     .success(false)
    //                     .message(ex.getMessage())
    //                     .build());

    // }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return ResponseEntity.badRequest()
            .body(ApiResponse.<Void>builder()
            .success(false)
            .message(ex.getMessage())
            .build());
    }
}
