package com.study.ducks.domain.chat.service;

import com.study.ducks.domain.chat.dto.ChatCreateRequest;
import com.study.ducks.domain.chat.entity.Chat;
import com.study.ducks.domain.chat.entity.ChatUsers;
import com.study.ducks.domain.chat.repository.ChatRepository;
import com.study.ducks.domain.commission.entity.Commission;
import com.study.ducks.domain.commission.repository.CommissionRepository;
import com.study.ducks.domain.user.entity.Users;
import com.study.ducks.domain.user.repository.UserRepository;
import com.study.ducks.exception.custom.IsInvalidUser;
import com.study.ducks.exception.custom.IsNotFoundCommission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final CommissionRepository commissionRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Long createChat(ChatCreateRequest chatCreateRequest) {

        Commission commission = commissionRepository.findById(chatCreateRequest.commissionId())
                .orElseThrow(IsNotFoundCommission::new);

        List<Users> users = userRepository.findAllById(chatCreateRequest.userIds());
        if(users.size() != chatCreateRequest.userIds().size()) {
            throw new IsInvalidUser();
        }

        List<ChatUsers> chatUsers = users.stream()
                .map(ChatUsers::of)
                .toList();

        Chat chat = Chat.builder()
                .commission(commission)
                .chatUsers(chatUsers)
                .build();

        chatRepository.save(chat);

        return chat.getChatId();
    }


//    public Long cre{
//
//        Optional<Users> user = userRepository.findByLoginId(userSignupRequest.loginId());
//
//        if(user.isPresent()) throw new IsExistedUser();
//
//        String encode = passwordEncoder.encode(userSignupRequest.password());
//
//        Users signUpUser = userRepository.save(Users.builder()
//                .loginId(userSignupRequest.loginId())
//                .password(encode)
//                .build());
//
//        return new UserSignupResponse(signUpUser.getUsersId(), signUpUser.getLoginId());
//    }
}
