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
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String userpw;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    // 레지스테이터스나 언레지스테이터스만 들어갈 수 있음
    private LocalDateTime lastLoginAt;
    private String regDate;
}
