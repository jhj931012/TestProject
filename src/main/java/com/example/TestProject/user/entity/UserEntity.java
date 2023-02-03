package com.example.TestProject.user.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "test_user")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "user_id")
    private String id;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100, unique = true)
    private String password;
    @Column(nullable = false, length = 30)
    private String nickName;
    @Column
    @CreationTimestamp
    private LocalDateTime regDate;

}
