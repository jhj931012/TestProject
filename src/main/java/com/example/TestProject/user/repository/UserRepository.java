package com.example.TestProject.user.repository;

import com.example.TestProject.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    boolean existsByEmail(String email);
}
