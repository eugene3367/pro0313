package com.example.pro0313.controller;

import com.example.pro0313.dto.LoginRequestDto;
import com.example.pro0313.dto.SignupRequestDto;
import com.example.pro0313.entity.User;
import com.example.pro0313.jwt.JwtUtil;
import com.example.pro0313.repository.UserRepository;
import com.example.pro0313.response.ApiResponse;
import com.example.pro0313.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<String> signup(@Valid @RequestBody SignupRequestDto dto) {
        userService.signup(dto);
        return ApiResponse.success("회원가입 성공");
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<String> login(@Valid @RequestBody LoginRequestDto dto) {
        User foundUser = userService.login(dto);
        String token = JwtUtil.generateToken(foundUser.getUsername());
        return ApiResponse.success(token);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
