package com.study.ducks.domain.chat.service;

import com.study.ducks.domain.chat.dto.ChatCreateRequest;

public interface ChatService {
    
    // 채팅방 생성
    Long createChat(ChatCreateRequest chatCreateRequest);
}
