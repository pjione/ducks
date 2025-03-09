package com.study.ducks.domain.user.service;

import com.study.ducks.domain.user.dto.UserSignupRequest;
import com.study.ducks.domain.user.dto.UserSignupResponse;
import com.study.ducks.domain.user.entity.User;
import com.study.ducks.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserSignupResponse signup(UserSignupRequest userSignupRequest) {

        Optional<User> user = userRepository.findByLoginId(userSignupRequest.loginId());

        //if(user.isPresent()) throw new IsExistedUser();
        //todo exception 관련 작업 후 적용 예정

        String encode = passwordEncoder.encode(userSignupRequest.password());

        User signUpUser = userRepository.save(User.builder()
                .loginId(userSignupRequest.loginId())
                .password(encode)
                .build());

        return new UserSignupResponse(signUpUser.getUserId(), signUpUser.getLoginId());
    }
}
