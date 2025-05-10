package com.study.ducks.domain.chat.repository;

import com.study.ducks.domain.chat.entity.ChatUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUsersRepository extends JpaRepository<ChatUsers, Long> {
}
