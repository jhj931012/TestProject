package com.example.TestProject.user.controller;

import com.example.TestProject.user.dto.UserRequestDTO;
import com.example.TestProject.user.dto.UserResponseDTO;
import com.example.TestProject.user.repository.UserRepository;
import com.example.TestProject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/test/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @Validated @RequestBody UserRequestDTO userRequestDTO
            ){



        UserResponseDTO userResponseDTO = userService.create(userRequestDTO);
        return ResponseEntity
                .ok()
                .body(userResponseDTO);

    }
}
