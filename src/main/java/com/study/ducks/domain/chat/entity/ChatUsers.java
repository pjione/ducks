package com.study.ducks.domain.chat.entity;

import com.study.ducks.common.BaseTimeEntity;
import com.study.ducks.domain.user.entity.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"chat_id", "user_id"}))
public class ChatUsers extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatUsersId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Builder
    public ChatUsers(Chat chat, Users user) {
        this.chat = chat;
        this.user = user;
    }

    public void addChat(Chat chat) {
        this.chat = chat;
    }

    public void addUser(Users user) {
        this.user = user;
    }

    public static ChatUsers of(Users user) {
        ChatUsers chatUsers = new ChatUsers();
        chatUsers.addUser(user);
        return chatUsers;
    }
}
