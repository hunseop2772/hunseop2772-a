package com.koreait.day4.model.entity;


import com.koreait.day4.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String name;
    private String userpw;
    private String hp;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
