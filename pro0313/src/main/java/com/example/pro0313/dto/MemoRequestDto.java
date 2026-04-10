package com.example.pro0313.dto;

import jakarta.validation.constraints.NotBlank;

public class MemoRequestDto {

    @NotBlank(message = "content는 필수입니다")
    private String content;

    public String getContent() {
        return content;
    }
}