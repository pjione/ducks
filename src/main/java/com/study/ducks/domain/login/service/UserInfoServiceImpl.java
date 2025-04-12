package com.study.ducks.domain.login.service;

import com.study.ducks.domain.login.dto.LoginRequest;
import com.study.ducks.domain.login.dto.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional(readOnly = true)
public class UserInfoServiceImpl  implements UserInfoService {

    @Override
    public LoginResponse loginProcess(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public void logoutProcess(LoginRequest loginRequest) {

    }
}
