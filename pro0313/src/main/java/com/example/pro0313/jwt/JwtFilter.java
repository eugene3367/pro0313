package com.example.pro0313.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        System.out.println("👉 JWT 필터 진입 URI: " + uri);

        // 로그인/회원가입은 통과
        if (uri.equals("/auth/login") || uri.equals("/auth/signup")) {
            System.out.println("👉 인증 제외 경로");
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        System.out.println("👉 Authorization 헤더: " + authHeader);

        // ❗ 토큰 없으면 바로 차단 (이거 중요)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("❌ 토큰 없음 또는 형식 오류");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = authHeader.substring(7);
        System.out.println("👉 토큰: " + token);
        boolean isValid = JwtUtil.validateToken(token);
        System.out.println("👉 validateToken 결과: " + isValid);

        if (!JwtUtil.validateToken(token)) {
            System.out.println("❌ 토큰 유효하지 않음");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String username = JwtUtil.getUsername(token);
        System.out.println("✅ 인증된 사용자: " + username);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
                );
        authentication.setDetails(request); // 🔥 추가

        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("✅ SecurityContext에 인증 정보 저장 완료");

        filterChain.doFilter(request, response);
    }
}