package com.example.pro0313.response;

import com.example.pro0313.exception.ErrorResponse;

public class ApiResponse<T> {

    private boolean success;
    private T data;
    private ErrorResponse error;

    public ApiResponse(boolean success, T data, ErrorResponse error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public ApiResponse() {}

    public boolean isSuccess() { return success; }
    public T getData() { return data; }
    public ErrorResponse getError() { return error; }

    // 성공
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = true;
        response.data = data;
        return response;
    }

    // fail
    public static <T> ApiResponse<T> fail(String message, int status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.success = false;
        response.error = new ErrorResponse(message, status);
        return response;
    }
}