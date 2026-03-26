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

    public boolean isSuccess() { return success; }
    public T getData() { return data; }
    public ErrorResponse getError() { return error; }
}