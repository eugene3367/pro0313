package com.example.pro0313.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupRequestDto {

    @NotBlank(message = "username은 필수입니다")
    private String username;

    @NotBlank(message = "password는 필수입니다")
    private String password;
}
