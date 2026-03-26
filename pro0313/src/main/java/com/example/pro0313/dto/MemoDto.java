package com.example.pro0313.dto;
import jakarta.validation.constraints.NotBlank;

public class MemoDto {

    private Long id;       // 응답용

    @NotBlank(message = "내용은 비어있을 수 없습니다")
    private String content;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}