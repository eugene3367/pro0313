package com.example.pro0313.service;

import com.example.pro0313.dto.LoginRequestDto;
import com.example.pro0313.dto.SignupRequestDto;
import com.example.pro0313.entity.User;
import com.example.pro0313.exception.CustomException;
import com.example.pro0313.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public void signup(SignupRequestDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword())) // 일단 암호화 X (나중에 추가)
                .build();

        userRepository.save(user);
    }

    // 로그인
    public User login(LoginRequestDto dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new CustomException("사용자 없음"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new CustomException("비밀번호가 틀렸습니다");        }

        return user;
    }
}
