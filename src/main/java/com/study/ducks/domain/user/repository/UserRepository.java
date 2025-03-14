package com.study.ducks.domain.user.repository;

import com.study.ducks.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    //Optional<User> findByLoginIdAndPassword(String loginId, String password);
    Optional<Users> findByLoginId(String loginId);
}
