package com.example.TestProject.user.dto;

import com.example.TestProject.user.entity.UserEntity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UserRequestDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 16)
    private String password;

    @NotBlank
    @Size(min = 4, max = 12)
    private String nickName;

    public UserEntity ToEntity(){
        UserEntity user = new UserEntity();
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setNickName(this.nickName);
        return user;
    }
}
