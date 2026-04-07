package com.example.pro0313.controller;

import com.example.pro0313.dto.LoginRequestDto;
import com.example.pro0313.dto.SignupRequestDto;
import com.example.pro0313.entity.User;
import com.example.pro0313.jwt.JwtUtil;
import com.example.pro0313.response.ApiResponse;
import com.example.pro0313.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<String> signup(@RequestBody SignupRequestDto dto) {
        userService.signup(dto);
        return ApiResponse.success("회원가입 성공");
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginRequestDto dto) {
        User foundUser = userService.login(dto);
        String token = JwtUtil.generateToken(foundUser.getUsername());
        return ApiResponse.success(token);
    }
}
