package com.example.pro0313.dto;

import com.example.pro0313.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {

    private Long id;
    private String content;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.content = memo.getContent();
    }

    public Long getId() { return id; }
    public String getContent() { return content; }

}
