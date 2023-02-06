package com.example.TestProject.user.dto;

import com.example.TestProject.user.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LoginResponseDTO {

    private String email;

    private LocalDateTime regDate;

    private String token;

    public LoginResponseDTO(UserEntity userEntity, String token) {
        this.email = userEntity.getEmail();
        this.regDate = userEntity.getRegDate();
        this.token = token;
    }
}
