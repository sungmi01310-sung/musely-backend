package com.layered.backend.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FirebaseAuthFilter extends OncePerRequestFilter {

    // /api/로 시작하지 않는 요청(AI 서버 콜백, Swagger 등)과 OPTIONS 요청은 검사하지 않음
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().startsWith("/api/")
                || "OPTIONS".equals(request.getMethod());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            response.sendError(401, "로그인이 필요합니다");
            return;
        }

        try {
            String idToken = header.substring(7);
            FirebaseToken token = FirebaseAuth.getInstance().verifyIdToken(idToken);
            request.setAttribute("uid", token.getUid());
            request.setAttribute("email", token.getEmail());
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("❌ 토큰 검증 실패: " + e.getMessage());
            response.sendError(401, "유효하지 않은 토큰입니다");
        }
    }
}