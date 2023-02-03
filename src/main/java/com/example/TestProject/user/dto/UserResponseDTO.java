package com.example.TestProject.user.dto;

import com.example.TestProject.user.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "email")
public class UserResponseDTO {

    private String email;
    private String nickName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    // 엔터티를 dto로 변경하는 생성자
    public UserResponseDTO(UserEntity entity) {
        this.email = entity.getEmail();
        this.nickName = entity.getNickName();
        this.regDate = entity.getRegDate();
    }
}
