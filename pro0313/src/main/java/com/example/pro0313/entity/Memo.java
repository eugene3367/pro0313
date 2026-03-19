package com.example.pro0313.entity;

import jakarta.persistence.*;

@Entity
public class Memo {

    public Memo() {} // 기본 생성자 추가

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String content;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}