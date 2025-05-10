package com.study.ducks.domain.chat.entity;

import com.study.ducks.common.BaseTimeEntity;
import com.study.ducks.domain.commission.entity.Commission;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commission_id", nullable = false)
    private Commission commission;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<ChatUsers> chatUsers = new ArrayList<>();

    @Builder
    public Chat(Commission commission, List<ChatUsers> chatUsers) {
        this.commission = commission;
        this.chatUsers = chatUsers;

        for(ChatUsers chatUser : chatUsers) {
            chatUser.addChat(this);
        }
    }
}
