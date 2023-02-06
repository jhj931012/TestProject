package com.example.TestProject.user.service;

import com.example.TestProject.security.TokenProvider;
import com.example.TestProject.user.dto.LoginResponseDTO;
import com.example.TestProject.user.dto.UserRequestDTO;
import com.example.TestProject.user.dto.UserResponseDTO;
import com.example.TestProject.user.entity.UserEntity;
import com.example.TestProject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenProvider tokenProvider;

    public UserResponseDTO create(final UserRequestDTO userRequestDTO) {

        final String email = userRequestDTO.getEmail();
        if (userRepository.existsByEmail(email)) {
            log.warn("Email already exists - {}", email);
            throw new RuntimeException("중복된 이메일입니다.");
        }

        String rawPassword = userRequestDTO.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        userRequestDTO.setPassword(encodedPassword);

        UserEntity savedUser = userRepository.save(userRequestDTO.ToEntity());

        return new UserResponseDTO(savedUser);
    }


    public LoginResponseDTO LoginCheck(
            final String email,
            final String rawPassword

    ) {
        UserEntity loginEmail = userRepository.findByEmail(email);


        if (loginEmail == null) {
            throw new RuntimeException("가입된 회원이 아닙니다.");
        }

        if(!passwordEncoder.matches(rawPassword, loginEmail.getPassword())) {
            throw new RuntimeException("비밀번호가 틀립니다.");
        }

        String token = tokenProvider.createToken(loginEmail);

        return new LoginResponseDTO(loginEmail, token);
    }
}
