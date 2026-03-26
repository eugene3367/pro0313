package com.example.pro0313.exception;

public class MemoNotFoundException extends RuntimeException {

    public MemoNotFoundException(Long id) {
        super("Memo not found with id: " + id);
    }
}