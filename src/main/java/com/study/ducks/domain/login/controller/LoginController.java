package com.study.ducks.domain.login.controller;

import com.study.ducks.domain.login.dto.KakaoUserInfoResponse;
import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import com.study.ducks.domain.login.dto.SigninRequest;
import com.study.ducks.domain.login.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "로그인 API", description = "로그인 API 입니다.")
@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @Operation(summary = "일반 사용자 로그인", description = "일반 사용자 로그인")
    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(HttpServletRequest httpServletRequest, @RequestBody @Validated LoginRequest loginRequest){
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession();

        LoginResponse loginResponse = loginService.loginProcess(loginRequest);
        session.setAttribute("loginResponse", loginResponse);
        session.setMaxInactiveInterval(1800);

        return ResponseEntity.ok()
                .body(loginResponse);
    }

    @Operation(summary = "일반 사용자 로그아웃", description = "일반 사용자 로그아웃")
    @PostMapping("/auth/logout")
    public ResponseEntity<LoginResponse> logout(HttpServletRequest httpServletRequest, @RequestBody @Validated LoginRequest loginRequest){
        HttpSession session = httpServletRequest.getSession(false);
        session.invalidate();

        return ResponseEntity.ok()
                .body(loginService.loginProcess(loginRequest));
    }

    @Operation(summary = "일반 사용자 회원가입", description = "사용자 회원가입")
    @PostMapping("/auth/logout")
    public ResponseEntity<LoginResponse> signIn(HttpServletRequest httpServletRequest, @RequestBody @Validated SigninRequest signinRequest){
        return ResponseEntity.ok()
                .body(loginService.signInProcess(signinRequest));
    }

}
