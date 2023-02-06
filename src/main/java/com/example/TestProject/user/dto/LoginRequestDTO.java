package com.example.TestProject.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LoginRequestDTO {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
