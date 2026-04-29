package com.example.pro0313.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String uri = request.getRequestURI();

// 🔥 이거 반드시 있어야 함
        if (uri.startsWith("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if (JwtUtil.validateToken(token)) {

                String username = JwtUtil.getUsername(token);

                // 👉 지금은 그냥 로그만 찍어도 OK

                System.out.println("인증된 사용자: " + username);

            } else {

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                return;
            }
        }

//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("토큰 없음");
//            return;
//        }
//
//        String token = authHeader.substring(7);
//
//        if (!JwtUtil.validateToken(token)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("토큰 유효하지 않음");
//            return;
//        }
//
//        String username = JwtUtil.getUsername(token);
//
//        request.setAttribute("username", username);

        // 통과
        filterChain.doFilter(request, response);
    }
}