package com.example.TestProject.user.service;

import com.example.TestProject.user.dto.UserRequestDTO;
import com.example.TestProject.user.dto.UserResponseDTO;
import com.example.TestProject.user.entity.UserEntity;
import com.example.TestProject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserResponseDTO create(final UserRequestDTO userRequestDTO) {

        final String email = userRequestDTO.getEmail();
        if (userRepository.existsByEmail(email)) {
            log.warn("Email already exists - {}", email);
            throw new RuntimeException("중복된 이메일입니다.");
        }

        UserEntity savedUser = userRepository.save(userRequestDTO.ToEntity());

        return new UserResponseDTO(savedUser);
    }
}
