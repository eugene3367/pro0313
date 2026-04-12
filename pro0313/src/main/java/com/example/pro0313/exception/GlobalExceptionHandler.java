package com.example.pro0313.exception;

import com.example.pro0313.response.ApiResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Object> handleValidationException(MethodArgumentNotValidException e) {

        String errorMessage = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ApiResponse.fail(errorMessage, 400);
    }

    @ExceptionHandler(MemoNotFoundException.class)
    public ApiResponse<Object> handleMemoNotFound(MemoNotFoundException e) {
        return ApiResponse.fail(e.getMessage(), 404);
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse<Object> handleCustomException(CustomException e) {
        return ApiResponse.fail(e.getMessage(), 400);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleAll(Exception e) {
        return ApiResponse.fail("Internal Server Error", 500);
    }
}