package com.example.pro0313.exception;

import com.example.pro0313.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(MethodArgumentNotValidException e) {

        String errorMessage = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity
                .status(400)
                .body(new com.example.pro0313.response.ApiResponse<>(false, null, new ErrorResponse(errorMessage, 400)));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception e) {
        return ResponseEntity
                .status(500)
                .body("Internal Server Error");
    }

    @ExceptionHandler(MemoNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleMemoNotFound(MemoNotFoundException e) {
        return ResponseEntity
                .status(404)
                .body(new ApiResponse<>(false, null,
                        new ErrorResponse(e.getMessage(), 404)));
    }
}